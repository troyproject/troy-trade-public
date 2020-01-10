package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.AccountBindDetails;
import com.troy.trade.api.model.dto.out.account.AccountBindDetailsResData;
import com.troy.trade.api.model.dto.out.account.AccountDetails;
import com.troy.trade.api.model.dto.out.account.assets.AccountAssetsResData;
import com.troy.trade.api.model.dto.out.account.level.AccountLevelResData;
import com.troy.trade.model.domain.account.AccountModel;
import com.troy.trade.model.dto.in.AccountReqDto;
import com.troy.trade.model.dto.out.AccountResDto;

import java.util.List;

/**
 * @author Han
 */
public interface IAccountService extends IBaseService<AccountModel> {

    /**
     * 账户级别
     *
     * @param userId
     * @return
     * @throws Exception
     */
    AccountLevelResData level(Long userId) throws Exception;

    /**
     * 获取账户资产详情
     *
     * @param userId
     * @return
     * @throws Exception
     */
    AccountAssetsResData getAssetsDetails(Long userId) throws Exception;

    /**
     * 绑定详情
     *
     * @param reqData
     * @return
     * @throws Exception
     */
    AccountBindDetailsResData getBoundDetails(AccountBindDetailsReqData reqData) throws Exception;

    /**
     * 解绑
     *
     * @param reqData
     * @throws Exception
     */
    void unbind(AccountUnbindReqData reqData) throws Exception;

    /**
     * 绑定账户
     *
     * @param reqData
     * @throws Exception
     */
    void bind(AccountBindReqData reqData) throws Exception;

    /**
     * 注册账户
     *
     * @param reqData
     * @param isBind
     * @return
     * @throws Exception
     */
    long register(AccountRegisterReqData reqData, boolean isBind);

    /**
     * 获取用户账户详情
     *
     * @param reqData
     * @return
     * @throws Exception
     */
    List<AccountDetails> getUserAccount(AccountListReqData reqData) throws Exception;

    /**
     * 获取自有账户及委托给自己的账户
     * @param reqData
     * @return
     */
    List<AccountDetails> getUserAccountAndAuth(AccountListReqData reqData) throws Exception;

    /**
     * 根据参数获取账户列表
     *
     * @param accountReqDto
     * @return
     */
    List<AccountResDto> getByExchCodeAndUserId(AccountReqDto accountReqDto) throws Exception;

    /**
     * 根据accountId获取账户信息
     * @param reqData
     * @return
     * @throws Exception
     */
    AccountBindDetails getAccountDetails(AccountBindDetailsReqData reqData) throws Exception;


}
