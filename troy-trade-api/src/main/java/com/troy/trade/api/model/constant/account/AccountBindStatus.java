package com.troy.trade.api.model.constant.account;

/**
 * 账户绑定状态
 *
 * @author Han
 */
public enum AccountBindStatus {

    BIND(1),
    UN_BIND(2);

    private int code;

    AccountBindStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccountBindStatus find(Integer code) {
        if (code == null) {
            return null;
        }
        for (AccountBindStatus e : AccountBindStatus.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
