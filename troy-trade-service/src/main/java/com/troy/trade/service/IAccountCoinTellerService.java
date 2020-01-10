package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.dto.out.ResPage;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.AccountCoinExtractApplyQueryReqDto;
import com.troy.trade.api.model.dto.in.account.AccountCoinRechargeQueryReqDto;
import com.troy.trade.api.model.dto.in.account.AccountCoinTellerQueryReqDto;
import com.troy.trade.api.model.dto.out.account.*;
import com.troy.trade.model.domain.account.AccountCoinTellerModel;

import java.util.List;

public interface IAccountCoinTellerService extends IBaseService<AccountCoinTellerModel> {


    /**
     * 根据条件查询充提币列表
     * @param accountCoinTellerQueryReqDto
     * @return
     */
    List<AccountCoinTellerResDto> queryByCondition(AccountCoinTellerQueryReqDto accountCoinTellerQueryReqDto);

    /**
     * 根据条件查询充提币列表-分页
     * @param accountCoinTellerQueryReqDto
     * @return
     */
    Res<AccountCoinTellerPageInfoResDto> queryByConditionByPage(AccountCoinTellerQueryReqDto accountCoinTellerQueryReqDto);


    /**
     * 根据条件查询充值币列表
     * @param accountCoinRechargeQueryReqDto
     * @return
     */
    List<AccountCoinRechargeResDto> queryByConditionRecharge(AccountCoinRechargeQueryReqDto accountCoinRechargeQueryReqDto);

    /**
     * admin - 根据条件查询充值币列表
     * @param reqDto
     * @return
     */
    ResPage<AccountCoinRechargeResDto> queryByConditionRechargeV2(AccountCoinRechargeQueryReqDto reqDto);

    /**
     * 根据条件查询提币列表
     * @param accountCoinExtractApplyQueryReqDto
     * @return
     */
    List<AccountCoinExtractApplyResDto> queryExtractApplyByCondition(AccountCoinExtractApplyQueryReqDto accountCoinExtractApplyQueryReqDto);

    /**
     * 后台-提币列表-分页
     * @param reqData
     * @return
     */
    ResPage<AccountCoinExtractApplyResDto> queryExtractApplyByConditionVs(AccountCoinExtractApplyQueryReqDto reqData);

    /**
     * 获取所有币种
     * @return
     */
    List<String> getDepositCoins();

    /**
     * 账户，币种汇总
     * @param reqDto
     * @return
     */
    Res<ResList<AccountCoinTellerHistorySummaryResDto>> getHistorySummary(AccountCoinTellerQueryReqDto reqDto);
}
