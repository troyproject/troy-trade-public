package com.troy.trade.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.troy.commons.dto.in.ReqFactory;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.commons.exchange.model.out.FullTickerResDto;
import com.troy.futures.exchange.api.model.dto.in.account.TickerFuturesReqDto;
import com.troy.futures.exchange.api.model.dto.out.account.KLineSwapResDto;
import com.troy.redis.RedisUtil;
import com.troy.trade.constant.ScheduledConstant;
import com.troy.trade.model.domain.exchange.ExchangeFuturesSymbolModel;
import com.troy.trade.service.IExchangeFuturesSymbolService;
import com.troy.trade.service.foreign.MarketFuturesExchangeClient;
import com.troy.trade.service.foreign.PushChangeClient;
import com.troy.trade.thread.SyncThreadPool;
import com.troy.trade.ws.api.model.dto.in.BalanceChangeReqDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 交易所合约ticker处理类
 */
@Slf4j
@Component
public class FuturesTickerExecute {

    @Autowired
    private MarketFuturesExchangeClient marketFuturesExchangeClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private InstrumentsExecute instrumentsExecute;

    @Autowired
    private KLineExecute kLineExecute;

    @Autowired
    private IExchangeFuturesSymbolService iExchangeFuturesSymbolService;

    @Autowired
    private PushChangeClient pushChangeClient;

    private static AtomicInteger futuresTaskCount = new AtomicInteger(0);

    public void ticker() {
        log.info("[同步合约ticker]-TaskCount={}", futuresTaskCount);
        long start = System.currentTimeMillis();
        List<ExchangeCode> exchangeCodeList = instrumentsExecute.getFuturesExchangeCodes();
        if (CollectionUtils.isEmpty(exchangeCodeList)) {
            log.info("[同步合约ticker]-根据ExchCode获取ExchangeCode列表为空");
            return;
        }
        exchangeCodeList.forEach(item -> {
            String key = String.format(ScheduledConstant.EXCHANGE_FUTURES_ALL_TICKER_REDIS_KEY, item.code());
            if (ExchangeCode.HUOBI_FUTURES_DELIVERY.equals(item)) {
                processFuturesTickerBySymbol(item, key);
            } else {
                processFuturesTicker(item, key);
            }
        });
        while (true) {
            try {
                Thread.sleep(100l);
                if (futuresTaskCount.intValue() == 0) {
                    log.info("[同步合约ticker]-总耗时{}毫秒", (System.currentTimeMillis() - start));
                    sendBalance();
                    break;
                } else {
                    log.info("[同步合约ticker]........TaskCount={}", futuresTaskCount);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async
    public void sendBalance() {
        try {
            pushChangeClient.sendAllFuturesBalanceChange(ReqFactory.getInstance().createReq(new BalanceChangeReqDto()));
        } catch (Exception e) {
            log.error("[同步合约ticker]-调用余额推送程序错误", e);
        }
    }

    /**
     * 根据交易所获取所有ticker
     *
     * @param exchCode
     * @param key
     */
    public void processFuturesTicker(ExchangeCode exchCode, String key) {
        long start1 = System.currentTimeMillis();
        TickerFuturesReqDto tickerFuturesReqDto = new TickerFuturesReqDto();
        tickerFuturesReqDto.setExchCode(exchCode);
        List<FullTickerResDto> list = null;
        try {
            Res<ResList<FullTickerResDto>> res = marketFuturesExchangeClient.ticker(ReqFactory.getInstance().createReq(tickerFuturesReqDto));
            if (null == res) {
                return;
            }
            log.info(String.format("获取ticker耗时{%s}毫秒", System.currentTimeMillis() - start1));
            log.info("[合约ticker-return]-{},{}", exchCode.code(), res.toString());
            if (!res.isSuccess()) {
                log.info("[合约ticker]-failed:{}", res.getHead());
                return;
            }
            if (null == res.getData()) {
                log.info("[合约ticker]-data空");
                return;
            }
            list = res.getData().getList();
            if (CollectionUtils.isEmpty(list)) {
                log.info("[合约ticker]-list空");
                return;
            }
            log.info("[合约ticker]-[{},tickerSize={}]", exchCode.code(), list.size());
        } catch (Exception e) {
            log.error("[合约ticker]-调用ticker处理error", e);
        }
        list.forEach(tickerResDto -> {
            SyncThreadPool.executeFuturesTicker(new Callable() {
                @Override
                public Object call() throws Exception {
                    futuresTaskCount.incrementAndGet();
                    ExchangeCode exchangeCode = exchCode;
                    FullTickerResDto dto = tickerResDto;
                    processFuturesTicker(key, exchangeCode, dto);
                    futuresTaskCount.decrementAndGet();
                    return "OK";
                }
            });
        });
    }

    /**
     * 根据交易所，合约symbol遍历，逐个获取ticker信息（适用于火币根据单个合约ID查询ticker）
     *
     * @param exchangeCode 交易所
     * @param key          缓存键
     */
    public void processFuturesTickerBySymbol(ExchangeCode exchangeCode, String key) {
        List<ExchangeFuturesSymbolModel> futuresSymbolModels = iExchangeFuturesSymbolService.selectFuturesSymbol(exchangeCode.code());
        if (CollectionUtils.isEmpty(futuresSymbolModels)) {
            return;
        }
        futuresSymbolModels.forEach(futuresSymbol -> {
            SyncThreadPool.executeFuturesTicker(new Callable() {
                @Override
                public Object call() throws Exception {
                    futuresTaskCount.incrementAndGet();
                    TickerFuturesReqDto tickerFuturesReqDto = new TickerFuturesReqDto();
                    tickerFuturesReqDto.setExchCode(exchangeCode);
                    tickerFuturesReqDto.setAlias(futuresSymbol.getContractType());
                    tickerFuturesReqDto.setSymbol(futuresSymbol.getSymbol());
//                    List<FullTickerResDto> fullTickerResDtoList = null;
//                    try {
//                        StringBuilder stringBuilder = new StringBuilder(String.format("exchCode=%s,symbol=%s,alias=%s", tickerFuturesReqDto.getExchCode(), tickerFuturesReqDto.getSymbol(), tickerFuturesReqDto.getAlias()));
//                        Res<ResList<FullTickerResDto>> res = marketFuturesExchangeClient.ticker(ReqFactory.getInstance().createReq(tickerFuturesReqDto));
//                        if (!res.isSuccess()) {
//                            log.info("[合约ticker]-[{}]-failed:{}", stringBuilder, res.getHead());
//                            return "FAIL";
//                        } else if (null == res.getData()) {
//                            log.info("[合约ticker]-[{}]-data null", stringBuilder);
//                            return "FAIL";
//                        } else {
//                            fullTickerResDtoList = res.getData().getList();
//                            if (CollectionUtils.isEmpty(fullTickerResDtoList)) {
//                                log.info("[合约ticker]-[{}]-data.list null", stringBuilder);
//                                return "FAIL";
//                            }
//                        }
//                        FullTickerResDto dto = fullTickerResDtoList.get(0);
//                        log.info("[ticker数据]-{}", dto);
//                        dto.setAlias(tickerFuturesReqDto.getAlias());
//                        ExchangeCode exchangeCode = tickerFuturesReqDto.getExchCode();
//                        processFuturesTicker(key, exchangeCode, dto);
//                    } catch (Exception e) {
//                        log.error("[逐个获取ticker信息]-[exchCode{},symbol={},alias={}]-error", tickerFuturesReqDto.getExchCode(), tickerFuturesReqDto.getSymbol(), tickerFuturesReqDto.getAlias());
//                    }
                    packSubmitTaskBySymbol(tickerFuturesReqDto, key);
                    futuresTaskCount.decrementAndGet();
                    return "OK";
                }
            });
        });
    }

    public void packSubmitTaskBySymbol(TickerFuturesReqDto tickerFuturesReqDto, String key) {
        List<FullTickerResDto> fullTickerResDtoList = null;
        try {
            StringBuilder stringBuilder = new StringBuilder(String.format("exchCode=%s,symbol=%s,alias=%s", tickerFuturesReqDto.getExchCode(), tickerFuturesReqDto.getSymbol(), tickerFuturesReqDto.getAlias()));
            Res<ResList<FullTickerResDto>> res = marketFuturesExchangeClient.ticker(ReqFactory.getInstance().createReq(tickerFuturesReqDto));
            if (!res.isSuccess()) {
                log.info("[合约ticker]-[{}]-failed:{}", stringBuilder, res.getHead());
                return;
            } else if (null == res.getData()) {
                log.info("[合约ticker]-[{}]-data null", stringBuilder);
                return;
            } else {
                fullTickerResDtoList = res.getData().getList();
                if (CollectionUtils.isEmpty(fullTickerResDtoList)) {
                    log.info("[合约ticker]-[{}]-data.list null", stringBuilder);
                    return;
                }
            }
            FullTickerResDto dto = fullTickerResDtoList.get(0);
            log.info("[ticker数据]-{}-{}", stringBuilder.toString(), dto);
            dto.setAlias(tickerFuturesReqDto.getAlias());
            ExchangeCode exchangeCode = tickerFuturesReqDto.getExchCode();
            processFuturesTicker(key, exchangeCode, dto);
        } catch (Exception e) {
            log.error("[逐个获取ticker信息]-[exchCode{},symbol={},alias={}]-error:", tickerFuturesReqDto.getExchCode(), tickerFuturesReqDto.getSymbol(), tickerFuturesReqDto.getAlias(), e);
        }
    }


    /**
     * 计算赋值，usdt24小时金额，日涨幅
     *
     * @param key
     * @param exchangeCode
     * @param fullTickerResDto
     */
    public void processFuturesTicker(String key, ExchangeCode exchangeCode, FullTickerResDto fullTickerResDto) {
        packUsdt24h(fullTickerResDto);
        try {
            log.info("[exchangeCode={},ticker={}]", exchangeCode.code(), fullTickerResDto);
            if (ExchangeCode.HUOBI_FUTURES_DELIVERY.equals(exchangeCode)) {
                packPriceChangePercent(fullTickerResDto);
            } else {
                packPriceChangePercent(exchangeCode, fullTickerResDto);
            }
            String mapKey = fullTickerResDto.getSymbol() + (StringUtils.isNotBlank(fullTickerResDto.getAlias()) ? "-" + fullTickerResDto.getAlias() : "");
            String val = objectMapper.writeValueAsString(fullTickerResDto);
            log.info("redis.put-[exchangeCode={},mapKey={},val={}]", exchangeCode.code(), mapKey, val);
            redisUtil.put(key, mapKey, val);
        } catch (Exception e) {
            log.error("[合约ticker]-入缓存-处理错误", e);
        }
    }

    /**
     * 计算日涨幅，open无需取Kline获取
     *
     * @param tickerResDto
     */
    public void packPriceChangePercent(FullTickerResDto tickerResDto) {
        if (null == tickerResDto) {
            return;
        }
        tickerResDto.setOpen(tickerResDto.getOpen());
        BigDecimal priceChangePercent = computePriceChangePercent(tickerResDto.getLast(), tickerResDto.getOpen());
        tickerResDto.setPriceChangePercent(priceChangePercent);
    }

    /**
     * 计算日涨幅
     *
     * @param exchangeCode
     * @param tickerResDto
     */
    public void packPriceChangePercent(ExchangeCode exchangeCode, FullTickerResDto tickerResDto) {
        long start = System.currentTimeMillis();
        KLineSwapResDto kLineSwapResDto = null;
        try {
            kLineSwapResDto = kLineExecute.klineByTradeSymbol(exchangeCode, tickerResDto.getTradeSymbol());
        } catch (Exception e) {
            log.error("packPriceChangePercent异常-[{},{}]-error:{}", exchangeCode.code(), tickerResDto.getTradeSymbol(), e);
        }
        if (null == kLineSwapResDto) {
            log.info("[line]-[{},{}]-null", exchangeCode.code(), tickerResDto.getTradeSymbol());
            return;
        }
        log.info("[line]-耗时{}毫秒", (System.currentTimeMillis() - start));
        tickerResDto.setOpen(kLineSwapResDto.getOpen());
        BigDecimal priceChangePercent = computePriceChangePercent(tickerResDto.getLast(), kLineSwapResDto.getOpen());
        tickerResDto.setPriceChangePercent(priceChangePercent);
    }

    /**
     * 日涨幅计算公式
     *
     * @param last
     * @param open
     * @return
     */
    private BigDecimal computePriceChangePercent(BigDecimal last, BigDecimal open) {
        if (null == open) {
            return BigDecimal.ZERO;
        }
        BigDecimal one = BigDecimal.valueOf(100);
        try {
            BigDecimal b = last.subtract(open);
            return b.multiply(one).divide(open, 4).setScale(2, BigDecimal.ROUND_FLOOR);
        }catch (Exception e){
            log.error("日涨幅计算公式-error", e);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 处理24小时成交额
     * 正向：
     * 24小时成交量*面值*最新成交价
     * 反向：
     * 24小时成交量*面值
     *
     * @param tickerResDto
     */
    public void packUsdt24h(FullTickerResDto tickerResDto) {
        try {
            if (StringUtils.isNotBlank(tickerResDto.getContractVal())) {
                BigDecimal contractVal = new BigDecimal(tickerResDto.getContractVal());
                BigDecimal usdt24h = BigDecimal.ZERO;
                if (null != tickerResDto.getIsInverse() && tickerResDto.getIsInverse()) {
                    usdt24h = tickerResDto.getVolume24h().multiply(contractVal).multiply(tickerResDto.getLast()).setScale(10, BigDecimal.ROUND_FLOOR);
                } else {
                    if (null != tickerResDto.getVolume24h() && null != contractVal) {
                        usdt24h = tickerResDto.getVolume24h().multiply(contractVal);
                    }
                }
                tickerResDto.setUsdt24h(usdt24h);
            }
        } catch (Exception e) {
            log.error("[处理24小时成交额]-[{}]-error", tickerResDto.getSymbol(), e);
        }
    }

}
