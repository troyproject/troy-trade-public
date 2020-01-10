package com.troy.trade.scheduled;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.troy.commons.dto.in.ReqFactory;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.commons.exchange.model.enums.ExchTypeEnum;
import com.troy.commons.utils.IdWorker;
import com.troy.futures.exchange.api.model.dto.in.account.ContractInfoReqDto;
import com.troy.futures.exchange.api.model.dto.out.account.ContractInfoResDto;
import com.troy.redis.RedisUtil;
import com.troy.trade.api.model.dto.in.exchange.ExchangeTypeListReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeTypeResDto;
import com.troy.trade.constant.Constant;
import com.troy.trade.constant.ScheduledConstant;
import com.troy.trade.model.domain.exchange.ExchangeCoinModel;
import com.troy.trade.model.domain.exchange.ExchangeFuturesSymbolModel;
import com.troy.trade.service.IExchangeCoinService;
import com.troy.trade.service.IExchangeFuturesSymbolService;
import com.troy.trade.service.IExchangeService;
import com.troy.trade.service.foreign.MarketFuturesExchangeClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 公共合约信息
 */
@Slf4j
@Component
public class InstrumentsExecute {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MarketFuturesExchangeClient marketFuturesExchangeClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private IExchangeService exchangeService;

    @Autowired
    private IExchangeFuturesSymbolService iExchangeFuturesSymbolService;

    @Autowired
    private IExchangeCoinService iExchangeCoinService;


    /**
     * 获取交易所的公共合约信息
     */
    public void initInstruments() {
        // List<ExchangeCode> codeList = Arrays.asList(ExchangeCode.OKEX_FUTURES_DELIVERY, ExchangeCode.OKEX_FUTURES_SWAP, ExchangeCode.HUOBI_FUTURES_DELIVERY);
        List<ExchangeCode> exchangeCodeList = getFuturesExchangeCodes();
        if (CollectionUtils.isEmpty(exchangeCodeList)) {
            log.info("[获取合约]-根据ExchCode获取ExchangeCode枚举为空");
            return;
        }
        long start = System.currentTimeMillis();
        exchangeCodeList.forEach(item -> {
            try {
                ContractInfoReqDto contractInfoReqDto = new ContractInfoReqDto();
                contractInfoReqDto.setExchCode(item);
                Res<ResList<ContractInfoResDto>> res = marketFuturesExchangeClient.contractInfo(ReqFactory.getInstance().createReq(contractInfoReqDto));
                // log.info("[获取所有合约面值]-[{}]-返回:{}", item.code(), res);
                // log.info(String.format("获取所有合约耗时{%s}毫秒", System.currentTimeMillis() - start));
                if (null == res) {
                    log.info("[获取合约]-null");
                    return;
                }
                if (!res.isSuccess()) {
                    log.info("[获取合约]-[{}]-failed:{}", item.code(), res.getHead());
                    return;
                }
                List<ContractInfoResDto> list = res.getData().getList();
                if (!CollectionUtils.isEmpty(list)) {
                    log.info("[获取合约]-{}-数量={}", item.code(), list.size());
                    String key = String.format(ScheduledConstant.INSTRUMENTS_ALL_PREFIX, item.code());
                    // 例如：key=BTC-USDT-191213
                    // Map<String, ContractInfoResDto> map = list.stream().collect(Collectors.toMap(k -> k.getTradeSymbol().replace(k.getTradeSymbol().split("-")[2], k.getContractType()), contractInfoResDto -> contractInfoResDto, (oldValue, newValue) -> oldValue));
                    Map<String, ContractInfoResDto> map = list.stream().collect(Collectors.toMap(k -> k.getTradeSymbol(), contractInfoResDto -> contractInfoResDto, (oldValue, newValue) -> oldValue));
                    // log.info(String.format("获取所有合约group耗时{%s}毫秒", System.currentTimeMillis() - start));
                    Map<String, String> cacheMap = new HashMap<>();
                    map.forEach((k, v) -> {
                        try {
                            // log.info("[获取所有合约面值]-{}-{}", item.code(), k);
                            // redisUtil.put(key, k, objectMapper.writeValueAsString(v));
                            cacheMap.put(k, objectMapper.writeValueAsString(v));
                        } catch (JsonProcessingException e) {
                            log.error("[获取合约]-[exchangeCode:{}]-error:转储格式错误", item, e);
                        }
                    });
                    // log.info(String.format("获取所有合约foreach耗时{%s}毫秒", System.currentTimeMillis() - start));
                    redisUtil.putAll(key, cacheMap);
                    // log.info(String.format("获取所有合约putAll耗时{%s}毫秒", System.currentTimeMillis() - start));
                    // 24小时过期
                    redisUtil.expire(key, 5 * 60L, TimeUnit.SECONDS);
                }
            } catch (Exception e) {
                log.error("[获取合约]-[exchangeCode:{}]-error:", item, e);
            }
        });
        log.info(String.format("[获取合约]-耗时{%s}毫秒", System.currentTimeMillis() - start));
    }

    /**
     * 获取交易所信息
     *
     * @return
     */
    public List<ExchangeCode> getFuturesExchangeCodes() {
        ExchangeTypeListReqDto exchangeTypeListReqDto = new ExchangeTypeListReqDto();
        List<Integer> typeList = new ArrayList<>();
        typeList.add(ExchTypeEnum.FUTURES_DELIVERY.getCode());
        typeList.add(ExchTypeEnum.FUTURES_SWAP.getCode());
        exchangeTypeListReqDto.setExchTypeList(typeList);
        List<ExchangeTypeResDto> exchangeCodeResDtoList = exchangeService.getExchCodeByType(exchangeTypeListReqDto);
        if (CollectionUtils.isEmpty(exchangeCodeResDtoList)) {
            log.info("[获取合约]-交易所列表为空");
            return null;
        }
        log.info("[获取合约]-合约交易所数量:{}", exchangeCodeResDtoList);
        List<ExchangeCode> exchangeCodeList = new ArrayList<>();
        exchangeCodeResDtoList.forEach(item -> {
            ExchangeCode exchangeCode = ExchangeCode.getExchangeCode(item.getExchCode());
            if (null != exchangeCode){
                exchangeCodeList.add(exchangeCode);
            }
        });
        return exchangeCodeList;
    }

    /**
     * 初始化一次数据库
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void initDbInstruments(String exchCode) {
        Map<String, List<ContractInfoResDto>> map = getContractInfoResDtoList(exchCode);
        if (!CollectionUtils.isEmpty(map)) {
            List<ExchangeFuturesSymbolModel> result = new ArrayList<>();
            Map<String, Set<String>> mapCoin = new HashMap<>();
            map.forEach((k, v) -> {
                if (CollectionUtils.isEmpty(v)) {
                    return;
                }
                Set<String> set = mapCoin.get(k);
                if (null == set) {
                    set = new HashSet<String>() {
                    };
                }

                Set<String> finalSet = set;
                v.forEach(item -> {
                    ExchangeFuturesSymbolModel model = new ExchangeFuturesSymbolModel();
                    model.setExchFuturesSymbolId(String.valueOf(IdWorker.getId()));
                    BeanUtils.copyProperties(item, model);
                    model.setExchCode(k);
                    model.setSymbol(item.getNewSymbol());
                    model.setBaseCoinId(k + "_" + item.getBaseCurrency().toLowerCase());
                    model.setBaseName(item.getBaseCurrency());
                    model.setQuoteCoinId(k + "_" + item.getQuoteCurrency().toLowerCase());
                    model.setQuoteName(item.getQuoteCurrency());
                    model.setContractValCoin(item.getContractValCurrency());
                    model.setSettlementCoin(item.getSettlementCurrency());
                    model.setCreateTime(new Date());
                    model.setInverse(null != item.getIsInverse() && item.getIsInverse() ? 1 : 0);
                    model.setBasePrecision(StringUtils.isNotBlank(item.getTradeIncrement()) ? Integer.valueOf(item.getTradeIncrement()) : 0);
                    model.setContractVal(item.getContractSize().stripTrailingZeros().toPlainString());
                    model.setStatus(Constant.STATUS_OFF);
                    model.setContractType(item.getAlias());
                    int length = 0;
                    if (StringUtils.isNotBlank(item.getTickSize())) {
                        String[] tickSize = item.getTickSize().split("\\.");
                        if (tickSize.length == 2) {
                            length = tickSize[1].length();
                        }
                    }
                    model.setQuotePrecision(length);
                    result.add(model);

                    finalSet.add(item.getBaseCurrency());
                    finalSet.add(item.getQuoteCurrency());
                    mapCoin.put(k, finalSet);
                });
            });
            try {
                if (!CollectionUtils.isEmpty(mapCoin)) {
                    List<ExchangeCoinModel> exchangeCoinModelList = new ArrayList<>();
                    mapCoin.forEach((k, v) -> {
                        for (String coin : v) {
                            ExchangeCoinModel exchangeCoinModel = new ExchangeCoinModel();
                            exchangeCoinModel.setExchangeCoinId((k + "_" + coin).toLowerCase());
                            exchangeCoinModel.setExchCode(k);
                            exchangeCoinModel.setName(coin);
                            exchangeCoinModel.setAliasName(coin);
                            exchangeCoinModel.setCreateTime(new Date());
                            exchangeCoinModel.setStatus(Constant.STATUS_OFF);
                            exchangeCoinModelList.add(exchangeCoinModel);
                        }

                    });
                    iExchangeCoinService.insertBatch(exchangeCoinModelList);
                }
                iExchangeFuturesSymbolService.insertBatch(result);
            } catch (Throwable throwable) {
                log.error("[初始化交易所合约信息]-error", throwable);
            }
        }
    }

    /**
     * 获取交易所币种
     * @return
     */
//    public Map<String, Map<String,ExchangeCoinModel>> getExchangeCoins(){
//        List<ExchangeCoinModel> list = iExchangeCoinService.queryForList();
//        if (CollectionUtils.isEmpty(list)){
//            return null;
//        }
//        // Map<String, ExchangeCoinModel> map = list.stream().collect(Collectors.toMap(ExchangeCoinModel::getExchCode, contractInfoResDto -> contractInfoResDto, (oldValue, newValue) -> oldValue));
//        Map<String, List<ExchangeCoinModel>> groupBy = list.stream().collect(Collectors.groupingBy(ExchangeCoinModel::getExchCode));
//        Map<String, Map<String,ExchangeCoinModel>> result = new HashMap<>();
//        groupBy.forEach((k,v)->{
//            Map<String, ExchangeCoinModel> map = v.stream().collect(Collectors.toMap(ExchangeCoinModel::getName, contractInfoResDto -> contractInfoResDto, (oldValue, newValue) -> oldValue));
//            result.put(k, map);
//        });
//        return result;
//    }

    /**
     * 单独获取合约信息
     *
     * @return
     */
    public Map<String, List<ContractInfoResDto>> getContractInfoResDtoList(String exchCode) {
        List<ExchangeCode> exchangeCodeList = getFuturesExchangeCodes();
        if (CollectionUtils.isEmpty(exchangeCodeList)) {
            log.info("[获取合约]-根据ExchCode获取ExchangeCode枚举为空");
            return null;
        }
        if (StrUtil.isNotBlank(exchCode) && exchangeCodeList.contains(ExchangeCode.getExchangeCode(exchCode))){
            List<ExchangeCode> codeList = new ArrayList<>();
            codeList.add(ExchangeCode.getExchangeCode(exchCode));
            exchangeCodeList = codeList;
        }
        Map<String, List<ContractInfoResDto>> map = new HashMap<>();
        exchangeCodeList.forEach(item -> {
            ContractInfoReqDto contractInfoReqDto = new ContractInfoReqDto();
            contractInfoReqDto.setExchCode(item);
            Res<ResList<ContractInfoResDto>> res = null;
            try {
                res = marketFuturesExchangeClient.contractInfo(ReqFactory.getInstance().createReq(contractInfoReqDto));
                // log.info("[获取所有合约面值]-[{}]-返回:{}", item.code(), res);
                if (null == res) {
                    log.info("[获取合约]-null");
                    return;
                }
                if (!res.isSuccess()) {
                    log.info("[获取合约]-[{}]-failed:{}", item.code(), res.getHead().toString());
                    return;
                }
            } catch (Exception e) {
                log.error("[获取合约]-[exchangeCode:{}]-error:", item, e);
            }
            List<ContractInfoResDto> list = res.getData().getList();
            if (!CollectionUtils.isEmpty(list)) {
                log.info("[获取合约]-{}-数量={}", item.code(), list.size());
                // result.addAll(list);
                map.put(item.code(), list);
            }
        });
        return map;
    }
}
