package com.troy.trade.api.model.constant.account;

/**
 * 账户权限类型
 *
 * @author Han
 */
public enum AccountPermissionType {

    READ(1),
    TRANSACTION(2);

    private int code;

    AccountPermissionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccountPermissionType find(Integer code) {
        if (code == null) {
            return null;
        }
        for (AccountPermissionType e : AccountPermissionType.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
