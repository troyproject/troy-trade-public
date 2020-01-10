package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.out.order.OrderDetails;
import com.troy.trade.exchange.api.model.dto.out.market.MyTradeResDto;
import com.troy.trade.model.domain.account.AccountTransFeeModel;
import com.troy.trade.model.domain.order.SpotTransPendingModel;
import com.troy.trade.model.dto.in.OrderModifyDto;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface IAccountTransFeeService extends IBaseService<AccountTransFeeModel> {


    /**
     * 账号余额更新
     *
     * @param orderModifyDto
     * @param spotTransPendingModel
     * @param isBuy
     */
    void updateAccountBlance(OrderModifyDto orderModifyDto, SpotTransPendingModel spotTransPendingModel, boolean isBuy, List<MyTradeResDto> myTradeResDtoList);

    BigDecimal queryFeeByOrder(OrderDetails transFlow);

}
