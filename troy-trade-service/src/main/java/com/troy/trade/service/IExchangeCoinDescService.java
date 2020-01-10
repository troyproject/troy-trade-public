package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinDescReqDto;
import com.troy.trade.model.domain.exchange.ExchangeCoinDescModel;

public interface IExchangeCoinDescService extends IBaseService<ExchangeCoinDescModel> {


    /********** admin后台查询相关 开始 ****************/

    /**
     * 根据参数修改币种详细信息
     * @param adminExchangeCoinDescReqDto
     * @author yanping
     * @return
     */
    Integer updateExchCoinDesc(AdminExchangeCoinDescReqDto adminExchangeCoinDescReqDto) throws Throwable;

    /********** admin后台查询相关 结束 ****************/
}
