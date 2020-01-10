package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.AssetsChargeHistoryReqData;
import com.troy.trade.api.model.dto.out.account.AssetsChargeHistoryList;
import com.troy.trade.model.domain.account.AccountCoinRechargeModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 充提币记录Mapper
 *
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountCoinRechargeMapper extends BaseMapper<AccountCoinRechargeModel> {

    List<AssetsChargeHistoryList> getChargeHistory(@Param("reqData") AssetsChargeHistoryReqData reqData);

    /**
     * 根据条件查询充提币记录
     *
     * @param accountCoinRechargeModel
     * @return
     */
    List<AccountCoinRechargeModel> queryByCondition(AccountCoinRechargeModel accountCoinRechargeModel);

    /**
     * 获取充币记录中的所有币种
     *
     * @return
     */
    List<String> getDepositCoins();
}