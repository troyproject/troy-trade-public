package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.account.AccountCoinExtractApplyModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 提现申请记录Mapper
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountCoinExtractApplyMapper extends BaseMapper<AccountCoinExtractApplyModel> {

    List<String> getExtractHistoryAddr(@Param("accountCoinId") Long accountCoinId);

    /**
     * 根据条件查询提现申请记录
     *
     * @param accountCoinExtractApplyModel
     * @return
     */
    List<AccountCoinExtractApplyModel> queryByCondition(AccountCoinExtractApplyModel accountCoinExtractApplyModel);

    /**
     * 获取提币申请记录中的所有币种
     *
     * @return
     */
    List<String> getWithdrawCoins();
}