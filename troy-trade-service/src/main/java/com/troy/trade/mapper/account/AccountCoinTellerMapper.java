package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.*;
import com.troy.trade.model.domain.account.AccountCoinTellerModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author zhangchengjie
 * @date 2019/09/23
 */
@Repository
public interface AccountCoinTellerMapper extends BaseMapper<AccountCoinTellerModel> {

    /**
     * 充提币历史
     * @param reqData
     * @return
     */
    List<AssetsChargeHistoryList> getChargeHistory(AssetsChargeHistoryReqData reqData);

    /**
     * 转币历史
     * @param reqData
     * @return
     */
    List<AssetsTransCoinRecord> getTransCoinRecord(AssetsTransCoinReqData reqData);


    /**
     * 充值体现币列表
     * @param accountCoinTellerQueryReqDto
     * @return
     */
    List<AccountCoinTellerModel> queryByCondition(AccountCoinTellerQueryReqDto accountCoinTellerQueryReqDto);

    /**
     * 自定义返回带分页
     * @param reqDto
     * @return
     */
    List<AccountCoinTellerResDto> queryByConditionCostom(AccountCoinTellerQueryReqDto reqDto);

    /**
     * 充值币条件查询
     * @param ccountCoinRechargeQueryReqDto
     * @return
     */
    List<AccountCoinRechargeResDto> queryByConditionRecharge(AccountCoinRechargeQueryReqDto ccountCoinRechargeQueryReqDto);

    /**
     * 提币条件查询
     * @param accountCoinExtractApplyQueryReqDto
     * @return
     */
    List<AccountCoinExtractApplyResDto> queryExtractApplyByCondition(AccountCoinExtractApplyQueryReqDto accountCoinExtractApplyQueryReqDto);

    /**
     * 筛选所有币的种类
     * @return
     */
    List<String> queryDepositCoins();

    /**
     * 查询账户今日提币数量
     * @param accountId
     * @return
     */
    BigDecimal countAccountTodayExtractAmount(@Param("accountId") Long accountId,
                                              @Param("operType") Integer operType,
                                              @Param("coinName") String coinName);

    /**
     * 查询账户，币种的充值提现汇总
     * @param reqDto
     * @return
     */
    List<AccountCoinTellerHistorySummaryResDto> queryHistorySummary(AccountCoinTellerQueryReqDto reqDto);
}