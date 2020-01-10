package com.troy.trade.api.model.constant.account;

/**
 * 账户所属平台
 * @author c
 * @date 2019/12/24
 */
public enum PlatformEnum {
    /**
     * 所属平台(0钱包 1troy 2其他平台)
     */
    WALLET(0),
    TROY(1),
    OTHER(2),
    ;

    private int code;

    PlatformEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PlatformEnum find(Integer code) {
        if (code == null) {
            return null;
        }
        for (PlatformEnum e : PlatformEnum.values()) {
            if (e.getCode() == code.intValue()) {
                return e;
            }
        }
        return null;
    }
}
