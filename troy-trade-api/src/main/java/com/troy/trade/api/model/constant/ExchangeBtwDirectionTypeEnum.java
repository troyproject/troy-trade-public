package com.troy.trade.api.model.constant;

/**
 * 0交易所账户到钱包账户，1btw钱包账户到交易所账户,
 * 站站交易所到角色来讲的充值，提现
 */
public enum ExchangeBtwDirectionTypeEnum {

    /**
     *
     */
    WITHDRAW(0),
    /**
     *
     */
    DEPOSIT(1);


    private Integer code;

    ExchangeBtwDirectionTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
