package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.ExchangeListReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeQueryListReqData;
import com.troy.trade.api.model.dto.in.exchange.ExchangeTypeListReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeUpdateReqDto;
import com.troy.trade.api.model.dto.out.exchange.*;
import com.troy.trade.model.domain.exchange.ExchangeModel;

import java.util.List;

/**
 * @author Han
 */
public interface IExchangeService extends IBaseService<ExchangeModel> {

    List<ExchangeDetails> list(ExchangeQueryListReqData reqData) throws Exception;

    /**
     * 获取所有交易所code列表
     * @author yanping
     * @return
     * @throws Throwable
     */
    List<ExchangeCodeResDto> getExchCode() throws Throwable;

    /**
     * 根据状态获取交易所列表
     * @return
     * @throws Throwable
     */
    List<ExchangeResDto> getExchangeList() throws Throwable;

    /**
     * 获取交易所列表所有数据
     *
     * @return
     */
    List<ExchangeFullResDto> getAllExchList();

    /**
     * 修改交易所的权重和状态
     */
    int updateSortAndStatus(AdminExchangeUpdateReqDto data);

    /**
     * 根据参数查找交易所信息
     * @param exchangeTypeListReqDto
     * @author yanping
     * @return
     */
    List<ExchangeTypeResDto> getExchCodeByType(ExchangeTypeListReqDto exchangeTypeListReqDto);

    /**
     * 根据参数查找交易所信息
     * @param exchangeListReqDto
     * @return name,aliasName
     */
    List<ExchangeResDto> getExchCodes(ExchangeListReqDto exchangeListReqDto);
}
