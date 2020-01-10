package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.AccountCoinExtractApplyQueryReqDto;
import com.troy.trade.api.model.dto.in.account.WithdrawApplyApproveReqDto;
import com.troy.trade.api.model.dto.out.account.AccountCoinExtractApplyResDto;
import com.troy.trade.model.domain.account.AccountCoinExtractApplyModel;

import java.util.List;

/**
 * 提币申请服务
 *
 * @author dp
 */
public interface IAccountCoinExtractApplyService extends IBaseService<AccountCoinExtractApplyModel> {

    /**
     * 根据条件查询提币申请列表
     * @param accountCoinExtractApplyQueryReqDto
     * @return
     */
    List<AccountCoinExtractApplyResDto> queryByCondition(AccountCoinExtractApplyQueryReqDto accountCoinExtractApplyQueryReqDto);

    /**
     * 审批 提币申请
     *
     * @param withdrawApplyApproveReqDto
     * @return
     */
    int approve(WithdrawApplyApproveReqDto withdrawApplyApproveReqDto);

    /**
     * 提现申请 审核-版本0928
     * @param withdrawApplyApproveReqDto
     * @return
     */
    Res approveVsecond(WithdrawApplyApproveReqDto withdrawApplyApproveReqDto);

    /**
     * 获取提币申请记录中的所有币种
     *
     * @return
     */
    List<String> getWithdrawCoins();
}
