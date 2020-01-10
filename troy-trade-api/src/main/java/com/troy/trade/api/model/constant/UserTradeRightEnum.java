package com.troy.trade.api.model.constant;

/**
 * description 是与否
 *
 * @author Han
 * @date 2018/10/8 10:08
 */
public enum UserTradeRightEnum {

    /**
     * 否
     */
    canTrade(1),
    /**
     * 是
     */
    canTrans(2),
    canWithdraw(4),
    canDeposit(3)
    ;

    private int code;

    UserTradeRightEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }



    public static UserTradeRightEnum find(Integer code) {
        if (code == null) {
            return null;
        }
        for (UserTradeRightEnum e : UserTradeRightEnum.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
