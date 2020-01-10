package com.troy.trade.api.model.constant;

/**
 * 交易所转btc账户记录状态
 */
public enum ExchangeTransferRecordsStatusEnum {

    /**
     * 未处理
     */
    DEFAULT(0),
    /**
     * 成功
     */
    SUCCESS(1),

    /**
     * 拒绝
     */
    REFUSED(2),

    /**
     * 失败
     */
    FAILED(3);

    private Integer code;

    ExchangeTransferRecordsStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
