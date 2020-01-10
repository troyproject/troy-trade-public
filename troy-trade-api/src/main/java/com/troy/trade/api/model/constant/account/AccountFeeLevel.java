package com.troy.trade.api.model.constant.account;

/**
 * 账户绑定状态
 *
 * @author Han
 */
public enum AccountFeeLevel {

    COMMON(1), // 默认等级
    LEVEL2(2),
    LEVEL3(3),
    LEVEL4(4),
    LEVEL5(5),
    LEVEL6(6);

    private int code;

    AccountFeeLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccountFeeLevel find(Integer code) {
        if (code == null) {
            return null;
        }
        for (AccountFeeLevel e : AccountFeeLevel.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
