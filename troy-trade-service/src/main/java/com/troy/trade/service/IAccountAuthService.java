package com.troy.trade.service;

import com.troy.commons.exception.service.ServiceException;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.constant.account.AccountPermissionType;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthAddReqData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthCancelReqData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthListReqData;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthDetail;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthListDetails;
import com.troy.trade.model.domain.account.AccountAuthModel;

import java.util.List;

/**
 * 账户授权
 *
 * @author Han
 */
public interface IAccountAuthService extends IBaseService<AccountAuthModel> {

    /**
     * 取消授权
     *
     * @param currentUserId
     * @param reqData
     * @throws Exception
     */
    void cancel(Long currentUserId, AccountAuthCancelReqData reqData) throws Exception;

    /**
     * 我的授权账户列表
     *
     * @param currentUserId
     * @param reqData
     * @return
     * @throws Exception
     */
    List<AccountAuthListDetails> myAuthority(Long currentUserId, AccountAuthListReqData reqData) throws Exception;

    /**
     * 授权给我的账户列表
     *
     * @param currentUserId
     * @param reqData
     * @return
     * @throws Exception
     */
    List<AccountAuthListDetails> authorizeToMe(Long currentUserId, AccountAuthListReqData reqData) throws Exception;

    /**
     * 获取账户授权详情
     *
     * @param accountId
     * @return
     * @throws Exception
     */
    List<AccountAuthDetail> getAccountAuthDetails(Long accountId) throws Exception;

    /**
     * 根据账户ID和用户ID获取账户授权详情
     *
     * @param accountId
     * @param userId
     * @param accountPermissionType
     * @return
     */
    AccountAuthDetail getAccountAuthDetail(Long accountId, Long userId, AccountPermissionType accountPermissionType);

    /**
     * 权限校验
     *
     * @param accountAuthDetail     账户权限详情
     * @param currentUserId         账户使用者
     * @param accountPermissionType 权限类型
     * @throws ServiceException StateTypeSuper.FAIL_VALUE_INVALID、StateTypeSuper.FAIL_NO_PERMISSION、ServiceResState.FAIL_ACCOUNT_DISABLED、ServiceResState.FAIL_ACCOUNT_AUTH_DISABLED、ServiceResState.FAIL_ACCOUNT_UNBOUND
     */
    void checkPermission(AccountAuthDetail accountAuthDetail, Long currentUserId, AccountPermissionType accountPermissionType) throws ServiceException;

    /**
     * 账户授权
     *
     * @param currentUserId
     * @param currentUsername
     * @param reqData
     * @throws Exception
     */
    void add(Long currentUserId, String currentUsername, AccountAuthAddReqData reqData) throws Exception;
}
