package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthDetail;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthListDetails;
import com.troy.trade.model.domain.account.AccountAuthModel;
import com.troy.trade.model.dto.in.account.AccountAuthListDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountAuthMapper extends BaseMapper<AccountAuthModel> {

    /**
     * 根据账户ID查询账户授权列表
     *
     * @param accountId
     * @return
     */
    List<AccountAuthDetail> queryAccountAuthDetail(Long accountId);


    /**
     * 查询授权基本信息
     *
     * @param accountAuthListDto
     * @return
     */
    List<AccountAuthListDetails> queryAccountAuthBasic(AccountAuthListDto accountAuthListDto) throws Exception;
}