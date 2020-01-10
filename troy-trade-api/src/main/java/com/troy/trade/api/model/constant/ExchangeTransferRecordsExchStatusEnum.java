package com.troy.trade.api.model.constant;

public enum ExchangeTransferRecordsExchStatusEnum {

    /**
     * 申请中
     */
    APPLYING(1),
    /**
     * 已完成
     */
    COMPLETED(2),

    /**
     * 已取消
     */
    CANCELED(3),

    /**
     * 失败
     */
    FAILED(4);

    private Integer code;

    ExchangeTransferRecordsExchStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
