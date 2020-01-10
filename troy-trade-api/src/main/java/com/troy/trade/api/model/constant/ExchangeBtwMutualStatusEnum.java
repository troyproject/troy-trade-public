package com.troy.trade.api.model.constant;

/**
 * 1-申请中、2-已完成、3-已取消、4-失败
 */
public enum ExchangeBtwMutualStatusEnum {

    APPLYING(1),
    FINISHED(2),
    CANCEL(3),
    FAIL(4);


    private Integer code;

    ExchangeBtwMutualStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
