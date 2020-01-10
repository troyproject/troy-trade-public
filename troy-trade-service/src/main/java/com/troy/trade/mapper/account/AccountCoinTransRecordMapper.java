package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.out.account.AssetsTransCoinRecord;
import com.troy.trade.model.domain.account.AccountCoinTransRecordModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author zhangchengjie
 * @date 2019/08/29
 */
@Repository
public interface AccountCoinTransRecordMapper extends BaseMapper<AccountCoinTransRecordModel> {

    List<AssetsTransCoinRecord> getByOutAccountCoinId(@Param("outAccountCoinId") Long outAccountCoinId);
}