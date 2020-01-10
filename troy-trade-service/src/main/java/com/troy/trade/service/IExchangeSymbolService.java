package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.AccountCoinNameReqData;
import com.troy.trade.api.model.dto.in.exchange.ExchangeCodeReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolIdsReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolDetailReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolReqDto;
import com.troy.trade.api.model.dto.out.account.AccountCoinNameResData;
import com.troy.trade.api.model.dto.out.exchange.*;
import com.troy.trade.model.domain.exchange.ExchangeSymbolModel;

import java.util.List;

public interface IExchangeSymbolService extends IBaseService<ExchangeSymbolModel> {

    /**
     * 查询列表
     * @param exchangeSymbolModel
     * @return
     */
    List<ExchangeSymbolModel> getSymbolList(ExchangeSymbolModel exchangeSymbolModel) ;
    /**
     * 批量保存数据
     * @param exchangeSymbolModelList
     * @return
     */
    int insertBatch(List<ExchangeSymbolModel> exchangeSymbolModelList) throws Throwable;

    /**
     * 批量修改数据
     * @param exchangeSymbolModelList
     * @return
     */
    int updateBatch(List<ExchangeSymbolModel> exchangeSymbolModelList) throws Throwable;

    /**
     * 根据交易所code获取交易对列表
     * @param exchangeCodeResDto
     * @author yanping
     * @return
     */
    List<ExchangeSymbolModel> getExchangeSymbolModelByExchCode(ExchangeCodeResDto exchangeCodeResDto) throws Throwable;

    /**
     * 根据交易所获取交易对列表
     * @param exchangeCodeReqDto
     * @author yanping
     * @return
     */
    ExchangeSymbolListResDto getExchangeSymbolList(ExchangeCodeReqDto exchangeCodeReqDto);

    /**
     * 根据参数查找交易对信息
     * @param exchangeSymbolDetailReqDto
     * @author yanping
     * @return
     */
    ExchangeSymbolDetailResDto getExchangeSymbolDetail(ExchangeSymbolDetailReqDto exchangeSymbolDetailReqDto);

    /**
     * 根据参数查找交易对的tiker信息
     * @param reqData
     * @author sz
     * @return
     */
    Res<ExchangeSymbolResDto> getExchangeSymbolTicker(ExchangeSymbolDetailReqDto reqData);

    /**
     * 根据参数查询交易对数据
     * @param exchangeSymbolReqDto
     * @author
     * @return
     */
    Res<ExchangeSymbolsPageInfoResDto> queryExchangeSymbolsByCondition(ExchangeSymbolReqDto exchangeSymbolReqDto);

    /**
     * 根据参数更新字段
     * @param exchangeSymbolReqDto
     * @return
     */
    Res modifySymbolStatusByCondition(ExchangeSymbolReqDto exchangeSymbolReqDto);

    /**
     * 根据主键查询
     * @param req
     * @return
     */
    ExchangeSymbolsResDto getExchangeSymbolDetailById(ExchangeSymbolReqDto req);

    Res<AccountCoinNameResData> toTrade(AccountCoinNameReqData data);

    List<ExchangeSymbolResDto> list(ExchangeSymbolIdsReqDto data);
}
