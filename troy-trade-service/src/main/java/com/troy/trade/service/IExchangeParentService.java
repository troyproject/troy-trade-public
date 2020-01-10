package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.ExchangeParentReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeParentResDto;
import com.troy.trade.model.domain.exchange.ExchangeParentModel;
import com.troy.trade.model.domain.order.NetworkExportModel;

import java.util.List;

/**
 */
public interface IExchangeParentService extends IBaseService<ExchangeParentModel> {


    public abstract List<ExchangeParentResDto> getParentExchList(ExchangeParentReqDto exchangeParentReqDto);


}
