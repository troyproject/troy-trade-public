package com.troy.trade.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.troy.commons.dto.in.ReqFactory;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.commons.utils.DateUtils;
import com.troy.futures.exchange.api.model.dto.in.order.KlineReqDto;
import com.troy.futures.exchange.api.model.dto.out.account.KLineSwapResDto;
import com.troy.redis.RedisUtil;
import com.troy.trade.constant.ScheduledConstant;
import com.troy.trade.service.foreign.MarketFuturesExchangeClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class KLineExecute {

    @Autowired
    private MarketFuturesExchangeClient marketFuturesExchangeClient;

    private static SimpleDateFormat formatter = new SimpleDateFormat(DateUtils.FORMAT_DATE_TIME_ISO8601);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private InstrumentsExecute instrumentsExecute;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取交易所合约ID的24小时之前的点数据
     *
     * @param
     */
    public KLineSwapResDto klineByTradeSymbol(ExchangeCode exchangeCode, String tradeSymbol) {
        Date date = DateUtils.dateAddHour(new Date(), -24);
        Date nextDate = DateUtils.addMinutes(date, 1);
        String startDateIso86 = formatter.format(date);
        String endDateIso86 = formatter.format(nextDate);
        KlineReqDto klineReqDto = new KlineReqDto();
        klineReqDto.setExchCode(exchangeCode);
        klineReqDto.setSymbol(tradeSymbol);
        klineReqDto.setStartDate(startDateIso86);
        klineReqDto.setEndDate(endDateIso86);
        klineReqDto.setSize(1);
        Res<ResList<KLineSwapResDto>> res = null;
        try {
            res = marketFuturesExchangeClient.kline(ReqFactory.getInstance().createReq(klineReqDto));
            if (!res.isSuccess()) {
                log.info("[获取单个symbol的kline]-[{},{}]-failed:{}", exchangeCode.code(), tradeSymbol, res.getHead());
                return null;
            }
        } catch (Throwable throwable) {
            log.error("[获取单个symbol的kline]-[{},{}]-error", exchangeCode.code(), tradeSymbol, throwable);
            return null;
        }
        List<KLineSwapResDto> list = res.getData().getList();
        if (CollectionUtils.isEmpty(list)) {
            log.info("[获取单个symbol的kline]-[{},{}]-list 空", exchangeCode.code(), tradeSymbol);
            return null;
        }
        KLineSwapResDto dto = list.get(0);
        log.info("[获取单个symbol的kline]-{},{},open={}", exchangeCode.code(), tradeSymbol, null != dto ? dto.getOpen() : null);
        return dto;
    }

    /**
     * 获取交易所合约ID的24小时之前的合约全部k线
     */
    public void futuresKline() {
        long start = System.currentTimeMillis();
        List<ExchangeCode> exchangeCodeList = instrumentsExecute.getFuturesExchangeCodes();
        if (CollectionUtils.isEmpty(exchangeCodeList)) {
            log.info("[定时获取kline]-交易所code空");
        }
        Date date = DateUtils.dateAddHour(new Date(), -24);
        Date nextDate = DateUtils.addMinutes(date, 1);
        String startDateIso86 = formatter.format(date);
        String endDateIso86 = formatter.format(nextDate);
        exchangeCodeList.forEach(exchangeCode -> {
            String insMasterKey = String.format(ScheduledConstant.INSTRUMENTS_ALL_PREFIX, exchangeCode.code());
            Map<String, String> mapInstruments = redisUtil.entries(insMasterKey);
            if (CollectionUtils.isEmpty(mapInstruments)) {
                log.info("[查询合约交易对信息]-instruments缓存为空");
                return;
            }
            mapInstruments.forEach((k, v) -> {
                process(k, exchangeCode, startDateIso86, endDateIso86);
            });
            //redisUtil.expire(klineKey, 60 * 5L, TimeUnit.SECONDS);
        });
        System.out.println(String.format("总耗时{%s}毫秒", System.currentTimeMillis() - start));
    }

    public void process(String symbol, ExchangeCode exchangeCode, String startDateIso86, String endDateIso86) {
        String klineKey = String.format(ScheduledConstant.EXCHANGE_FUTURES_KLINE_REDIS_KEY, exchangeCode.code());
        KlineReqDto klineReqDto = new KlineReqDto();
        klineReqDto.setExchCode(exchangeCode);
        klineReqDto.setSymbol(symbol);
        klineReqDto.setStartDate(startDateIso86);
        klineReqDto.setEndDate(endDateIso86);
        klineReqDto.setSize(1);
        Res<ResList<KLineSwapResDto>> res = null;
        try {
            res = marketFuturesExchangeClient.kline(ReqFactory.getInstance().createReq(klineReqDto));
            if (!res.isSuccess()) {
                log.info("[定时获取kline]-failed");
                return;
            }
        } catch (Throwable throwable) {
            log.error("[定时获取kline]-[{}]-error", symbol, throwable);
            return;
        }
        List<KLineSwapResDto> list = res.getData().getList();
        if (CollectionUtils.isEmpty(list)) {
            log.info("[定时获取kline]-list 空");
            return;
        }
        try {
            KLineSwapResDto dto = list.get(0);
            log.info("[定时获取kline]-{}-{}", exchangeCode.code(), symbol);
            String keyAlias = StringUtils.isNotBlank(dto.getAlias()) ? symbol.replace(symbol.split("-")[2], dto.getAlias()) : symbol;
            redisUtil.put(klineKey, keyAlias, objectMapper.writeValueAsString(list.get(0)));
        } catch (JsonProcessingException e) {
            log.error("[获取合约]-[exchangeCode:{}]-error:转储格式错误", exchangeCode.code(), e);
        }
    }

}
