package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.AccountCoinRechargeQueryReqDto;
import com.troy.trade.api.model.dto.out.account.AccountCoinRechargeResDto;
import com.troy.trade.model.domain.account.AccountCoinRechargeModel;

import java.util.List;

/**
 * 充提币服务
 *
 * @author dp
 */
public interface IAccountCoinRechargeService extends IBaseService<AccountCoinRechargeModel> {

    /**
     * 根据条件查询充提币列表
     *
     * @param accountCoinRechargeQueryReqDto
     * @return
     */
    List<AccountCoinRechargeResDto> queryByCondition(AccountCoinRechargeQueryReqDto accountCoinRechargeQueryReqDto);

    /**
     * 获取充币记录中的所有币种
     *
     * @return
     */
    List<String> getDepositCoins();
}
