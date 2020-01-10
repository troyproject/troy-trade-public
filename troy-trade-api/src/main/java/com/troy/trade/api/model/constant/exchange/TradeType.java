package com.troy.trade.api.model.constant.exchange;

import com.troy.commons.enums.BaseEnum;

/**
 * 交易所支持的交易类型
 *
 * @author dp
 */
public enum TradeType implements BaseEnum<Integer> {
    LIMIT(1, "限价交易"),
    MARKET(2, "市价交易"),
    LIMIT_MARKET(3, "限价交易、市价交易"),
    ;

    /**
     * 交易所exchCode
     */
    private Integer code;

    /**
     * 描述
     */
    private String value;

    TradeType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String desc() {
        return value;
    }
}
