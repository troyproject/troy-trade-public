package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import com.troy.trade.api.model.constant.account.AccountPermissionType;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询用户是否具有对账户操作权限
 *
 * @author dp
 */
@Setter
@Getter
public class AccountPermissionReqDto extends ReqData {

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账户权限
     */
    private AccountPermissionType accountPermissionType;

    private String token;
}
