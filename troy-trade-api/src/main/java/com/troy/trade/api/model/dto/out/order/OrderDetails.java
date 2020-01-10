package com.troy.trade.api.model.dto.out.order;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author sz
 */
@Setter
@Getter
public class OrderDetails extends ResData {

    private Long accountId;
    private Long spotTransId;
    private Long userId;
    private String orderId;
    private Long thirdCreateTime;

    /**
     * 下单方向（1-买，2-卖）
     */
    private Integer side;
    private String symbol;

    /**
     * 下单价格
     */
    private BigDecimal price;

    /**
     * 下单数量
     */
    private BigDecimal amount;
    private BigDecimal totalCashAmount;

    /**
     * 已成交量
     */
    private BigDecimal filledAmount;

    /**
     * 未成交数量
     */
    private BigDecimal leftAmount;
    private Integer status;
    private BigDecimal priceAvg;
    private Long exchAccountId;
    private String dealFee;
    private String exchCode;
    private Long userAccountId;

    /**
     * 交易类型（1-限价交易，2-市价交易）
     */
    private Integer transType;
    /**
     * 成交比例
     */
    private double sucessPercent;

    private String exchSymbolId;

}
