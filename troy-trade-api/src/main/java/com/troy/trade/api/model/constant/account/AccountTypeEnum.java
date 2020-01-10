package com.troy.trade.api.model.constant.account;

/**
 * 账户类型
 *
 * @author caq
 */
public enum AccountTypeEnum {

    /**
     * 0:默认值; 1：币币；2：杠杆；3：期货交割；4：期货永续；5：troy；6：风控；7：杠杆-逐仓'
     */
    DEFAULT(0),
    SPOT(1),
    MARGIN(2),
    FUTURES_DELIVERY(3),
    FUTURES_SWAP(4),
    TROY(5),
    RISK(6),
    MARGIN_FIXED(7)
    ;

    private int code;

    AccountTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AccountTypeEnum find(Integer code) {
        if (code == null) {
            return null;
        }
        for (AccountTypeEnum e : AccountTypeEnum.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
