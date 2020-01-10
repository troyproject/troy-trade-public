package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResPage;
import com.troy.trade.api.model.dto.in.exchange.AdminExchangeBtwMutualTransferReqDto;
import com.troy.trade.api.model.dto.out.exchange.AdminExchangeBtwMutualTransferResDto;

public interface IExchangeBtwMutualTransferService {

    Res fromExchangeToBtw(AdminExchangeBtwMutualTransferReqDto reqDto);

    Res fromBtwToExchange(AdminExchangeBtwMutualTransferReqDto reqDto);

    void schedulerUpdateDrawStatus();

    ResPage<AdminExchangeBtwMutualTransferResDto> getByCondition(AdminExchangeBtwMutualTransferReqDto reqDto);

    Res updateByConditionPrimary(AdminExchangeBtwMutualTransferReqDto reqDto);
}
