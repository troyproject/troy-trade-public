package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.*;
import com.troy.trade.api.model.dto.out.exchange.*;
import com.troy.trade.model.domain.exchange.ExchangeFuturesSymbolModel;
import com.troy.trade.model.domain.exchange.ExchangeSymbolModel;

import java.util.List;

public interface IExchangeFuturesSymbolService extends IBaseService<ExchangeFuturesSymbolModel> {
    /**
     * 批量保存数据
     *
     * @param exchangeSymbolModelList
     * @return
     */
    int insertBatch(List<ExchangeFuturesSymbolModel> exchangeSymbolModelList) throws Throwable;


    /**
     * 根据交易所code获取交易对列表
     *
     * @param exchangeCodeResDto
     * @return
     */
    List<ExchangeFuturesSymbolModel> getExchangeSymbolModelByExchCode(ExchangeFuturesCodeReqDto exchangeCodeResDto) throws Throwable;

    /**
     * 根据参数查找交易对信息
     *
     * @param exchangeSymbolDetailReqDto
     * @return
     */
    ExchangeSymbolDetailResDto getExchangeSymbolDetail(ExchangeFuturesSymbolDetailReqDto exchangeSymbolDetailReqDto);

    /**
     * 交易所合约信息
     *
     * @param exchangeCodeReqDto
     * @return
     */
    ExchangeFuturesSymbolListResDto getFuturesExchangeSymbols(ExchangeFuturesSymbolReqDto exchangeCodeReqDto);

    /**
     * 缓存交易所币对信息
     *
     * @param exchangeCode
     * @return
     */
    List<ExchangeFuturesSymbolModel> getFuturesSymbolsFromCache(String exchangeCode);

    /**
     * 刷新缓存交易所币对信息
     *
     * @param reqDto
     */
    Res refreshCacheFuturesSymbols(ExchangeFuturesCodeReqDto reqDto);

    List<ExchangeFuturesSymbolModel> selectFuturesSymbol(String exchangeCode);

    ExchangeFuturesSymbolInfoResDto getBySymbol(ExchangeFuturesSymbolReqDto reqDto);

}
