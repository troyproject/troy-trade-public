package com.troy.trade.model.dto.in;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 */
@Getter
@Setter
public class GroupByUserAmountDto implements Serializable {

    private String exchCode;
    /**
     * 交易对
     */
    private String symbol;

    /**
     * 用户ID
     */
    private Long userId;

    private BigDecimal totalAmount;
}
