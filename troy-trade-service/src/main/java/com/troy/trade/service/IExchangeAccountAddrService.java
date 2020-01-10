package com.troy.trade.service;

import com.troy.commons.dto.out.ResPage;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.ExchangeAccountReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeAccountAddrResDto;
import com.troy.trade.model.domain.account.ExchangeAccountAddrModel;

public interface IExchangeAccountAddrService extends IBaseService<ExchangeAccountAddrModel> {

    ResPage<ExchangeAccountAddrResDto> queryByCondition(ExchangeAccountReqDto reqDto);
}
