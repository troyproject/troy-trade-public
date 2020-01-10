package com.troy.trade.service;

import com.troy.trade.model.domain.account.AccountBindModel;
import com.troy.trade.model.domain.exchange.ExchangeAccountModel;
import com.troy.trade.model.domain.order.SpotTransPendingModel;

public interface ITaskService {

    /**
     * 单个同步第三方订单状态
     *
     * @param spotTransPendingModel
     */
    void syncSingleThirdOrderStatus(SpotTransPendingModel spotTransPendingModel);

    /**
     * 单个同步第三方订单状态
     *
     * @param spotTransPendingId
     */
    void syncSingleThirdOrderStatus(Long spotTransPendingId);

    /**
     * 为exchange_account 同步第三方订单状态
     *
     * @param exchangeAccountModel
     * @throws Exception
     */
    void syncExchangeAccountThirdOrderStatus(ExchangeAccountModel exchangeAccountModel);

    /**
     * account_bind 同步第三方订单状态
     *
     * @param accountBindModel
     * @throws Exception
     */
    void syncAccountBindThirdOrderStatusJob(AccountBindModel accountBindModel);



    /**
     * 将成交的临时订单计算手续费，完全成交后删除
     */
    void syncThirdDelFee();

    /**
     * 根据交易对和交易所 同步子订单数据
     *
     * @param accountBindModel exchCode
     */
     void syncAccountBindByExchCode(AccountBindModel accountBindModel ,String exchCode) ;




    /**
     * 根据交易对和交易所 同步子订单数据
     *
     * @param exchangeAccountModel exchCode
     */
     void syncExchangeAccountByExchCode(ExchangeAccountModel exchangeAccountModel,String exchCode ) ;
}
