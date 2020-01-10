package com.troy.trade.api.model.constant.account;

/**
 * 账户所属
 *
 * @author Han
 */
public enum AccountOwnership {

    WALLET(0),
    TROY(1),
    OTHER(2);

    private int code;

    AccountOwnership(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccountOwnership find(Integer code) {
        if (code == null) {
            return null;
        }
        for (AccountOwnership e : AccountOwnership.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
