package com.troy.trade.mapper.account;

import com.troy.trade.api.model.dto.out.account.assets.AccountAssetsDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface AccountCoinForModifyMapper {

    /**
     * 查询账户资产详情
     *
     * @param mod
     * @param accountIdList
     * @return
     * @throws Exception
     */
    List<AccountAssetsDetails> selectForAccountAssetsDetails(@Param("accountIdList") Set<Long> accountIdList, @Param("mod") int mod) throws Exception;
}