package com.troy.trade.api.model.dto.out.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhangchengjie
 * @date 2019/08/29
 */
@Setter
@Getter
public class TradeCoinDto implements Serializable {

    /**
     * 账户币种id
     */
    private Long accountCoinId;

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 交易所币种id
     */
    private Long exchangeCoinId;

    /**
     * 可用额
     */
    private BigDecimal usableAmount;

    private BigDecimal totalAmount;

}
