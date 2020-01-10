package com.troy.trade.api.model.constant;

public enum ReviewStautsEnum {

    /**
     * 提现审核中
     */
    DRAW_REVIEW_ING(11),
    /**
     * 提现审核失败
     */
    DRAW_REVIEW_FAIL(14);

    private int code;

    ReviewStautsEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
