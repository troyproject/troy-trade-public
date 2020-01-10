package com.troy.trade.api.model.constant.exchange;

/**
 * 绑定账户状态
 *
 * @author Han
 */
public enum BindAccountStatus {

    /**
     * 不可以绑定账户
     */
    NO(0),
    /**
     * 可以绑定账户
     */
    YES(1);

    private int code;

    BindAccountStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BindAccountStatus find(Integer code) {
        if (code == null) {
            return null;
        }
        for (BindAccountStatus e : BindAccountStatus.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
