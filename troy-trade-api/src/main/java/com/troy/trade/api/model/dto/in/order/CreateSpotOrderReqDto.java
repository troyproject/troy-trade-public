package com.troy.trade.api.model.dto.in.order;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 创建订单入参
 *
 * @author dp
 */
@Setter
@Getter
public class CreateSpotOrderReqDto extends ReqData {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 交易所CODE
     */
    @NotBlank(message = "交易所CODE不能为空")
    private String exchCode;

    /**
     * 账户ID
     */
    @NotBlank(message = "账户ID不能为空")
    private Long accountId;

    /**
     * 交易方向（1-买 2-卖）
     */
    @NotNull
    @Range(min = 1, max = 2, message = "交易方向有误")
    private Integer orderSide;

    /**
     * 下单类型（1-限价交易 2-市价交易）
     */
    @NotNull
    @Range(min = 1, max = 2, message = "交易类型有误")
    private Integer orderType;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 市价买入量（市价交易买入必传）
     */
    private BigDecimal marketCashAmount;

    /**
     * 交易对ID
     */
    @NotBlank
    private String exchSymbolId;

    /**
     * 交易对
     */
    @NotBlank
    private String symbol;

    /**
     * 来源（0-前台，1-机器人）
     */
    @NotNull(message = "来源必传")
    private Integer source;

}
