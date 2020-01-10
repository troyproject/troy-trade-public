package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.account.AccountCoinRechargeBillModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/09/18
 */
@Repository
public interface AccountCoinRechargeBillMapper extends BaseMapper<AccountCoinRechargeBillModel> {

    /**
     * 查询数据库中最后一次归集的id
     *
     * @return
     */
    String selectLastBtwBillId();

    /**
     * 批量插入数据
     *
     * @param billModelList
     */
    void batchInsert(@Param("billModelList") List<AccountCoinRechargeBillModel> billModelList);

}