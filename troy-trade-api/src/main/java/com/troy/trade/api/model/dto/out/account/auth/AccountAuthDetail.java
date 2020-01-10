package com.troy.trade.api.model.dto.out.account.auth;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountAuthDetail implements Serializable {

    private static final long serialVersionUID = 299629099151223161L;

    /**
     * 授权的账户
     */
    private Long accountId;

    /**
     * 账户拥有者ID
     */
    private Long userId;

    /**
     * 账户拥有者名称
     */
    private String username;

    /**
     * 被委托者ID
     */
    private Long proxyUserId;

    /**
     * 被委托者名称
     */
    private String proxyUsername;

    /**
     * 主账户
     */
    private Long masterAccountId;

    /**
     * 账户所属平台
     *
     * @see com.troy.trade.api.model.constant.account.AccountOwnership
     */
    private Integer accountOwnership;

    /**
     * 账户是否禁用
     *
     * @see com.troy.trade.api.model.constant.YesOrNo
     */
    private Integer accountEnabled;

    /**
     * 权限类型
     *
     * @see com.troy.trade.api.model.constant.account.AccountPermissionType
     */
    private Integer permissionType;

    /**
     * 权限类型
     *
     * @see com.troy.trade.api.model.constant.YesOrNo
     */
    private Integer permissionEnabled;

    /**
     * 绑定账户ID
     */
    private Long bindId;

    /**
     * 权限类型
     *
     * @see com.troy.trade.api.model.constant.account.AccountBindStatus
     */
    private Integer bindStatus;
}