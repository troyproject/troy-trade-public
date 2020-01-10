package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import com.troy.trade.api.model.constant.account.AccountPermissionType;
import lombok.Getter;
import lombok.Setter;

/**
 * 账户ID
 */
@Setter
@Getter
public class AccountIdReqDto extends ReqData {

    /**
     * 用户账户ID
     */
    private Long accountId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账户权限类型
     */
    private AccountPermissionType permissionType;

    public AccountIdReqDto() {
        super();
    }

//    public AccountIdReqDto(Long accountId) {
//        this.accountId = accountId;
//    }
//
//    public static AccountIdReqDto getInstance(Long accountId){
//        return new AccountIdReqDto(accountId);
//    }

    public AccountIdReqDto(Long accountId, Long userId, AccountPermissionType permissionType) {
        this.accountId = accountId;
        this.userId = userId;
        this.permissionType = permissionType;
    }

    public static AccountIdReqDto getInstance(Long accountId, Long userId, AccountPermissionType permissionType){
        return new AccountIdReqDto(accountId, userId,permissionType);
    }
}
