package com.troy.trade.api.model.constant;

/**
 * 交易对类型枚举
 */
public enum SymbolTypeEnum {
    SPOT("spot", "现货"),
    THIS_WEEK("this_week", "当周"),
    NEXT_WEEK("next_week", "次周"),
    QUARTER("quarter", "季度"),
    SWAP("swap", "永续"),
    // 传参校验使用
    FUTURES("futures", "合约");
    /**
     * 账户类型type
     */
    private String type;
    /**
     * 描述
     */
    private String desc;

    SymbolTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
