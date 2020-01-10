package com.troy.trade.api.model.constant.exchange;

/**
 * 注册账户状态
 *
 * @author Han
 */
public enum RegisterAccountStatus {

    /**
     * 暂不支持开户
     */
    NO_SUPPORT(0),
    /**
     * 联系客服开户
     */
    APPLY(1),
    /**
     * 支持开户
     */
    SUPPORT(2),
    ;

    private int code;

    RegisterAccountStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RegisterAccountStatus find(Integer code) {
        if (code == null) {
            return null;
        }
        for (RegisterAccountStatus e : RegisterAccountStatus.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
