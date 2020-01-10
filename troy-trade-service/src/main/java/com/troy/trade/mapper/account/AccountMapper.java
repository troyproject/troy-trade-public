package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.AccountListReqData;
import com.troy.trade.api.model.dto.out.account.AccountDetails;
import com.troy.trade.model.domain.account.AccountModel;
import com.troy.trade.model.dto.in.AccountReqDto;
import com.troy.trade.model.dto.out.AccountResDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountMapper extends BaseMapper<AccountModel> {

    /**
     * 查询用户下自有账户
     * @param reqData
     * @return
     */
    List<AccountDetails> selectForAccountDetails(AccountListReqData reqData) throws Exception;

    /**
     * 查询用户下自有账户及受委托的别人的账户
     * @param reqData
     * @return
     */
    List<AccountDetails> selectForAccountDetailsAndAuth(AccountListReqData reqData);

    List<AccountDetails> selectForTransCoin(AccountListReqData reqData);

    /**
     * 根据参数获取账户列表
     * @param accountReqDto
     * @return
     */
    List<AccountResDto> getByExchCodeAndUserId(AccountReqDto accountReqDto);

}