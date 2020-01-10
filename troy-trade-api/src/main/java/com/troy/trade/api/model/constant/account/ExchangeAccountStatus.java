package com.troy.trade.api.model.constant.account;

/**
 * 账户绑定状态
 *
 *
 *   状态（0-禁用，1-启用）
 *
 */
public enum ExchangeAccountStatus {

    YES(1),
    NO(0);

    private int code;

    ExchangeAccountStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ExchangeAccountStatus find(Integer code) {
        if (code == null) {
            return null;
        }
        for (ExchangeAccountStatus e : ExchangeAccountStatus.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
