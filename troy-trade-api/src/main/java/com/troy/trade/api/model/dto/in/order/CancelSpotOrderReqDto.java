package com.troy.trade.api.model.dto.in.order;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 撤销币币订单入参
 *
 * @author dp
 */
@Setter
@Getter
public class CancelSpotOrderReqDto extends ReqData {

    /**
     * 当前用户ID
     */
    private Long userId;

    /**
     * 当前账户ID
     */
    @NotNull(message = "当前账户ID不能为空")
    private Long accountId;

    /**
     * 交易对ID
     */
    @NotNull(message = "交易对ID不能为空")
    private String exchSymbolId;

    /**
     * 撤单类型（0-单个 1-全部）
     * @see com.troy.trade.api.model.constant.order.TradeOrderConstant.CancelType
     */
    @NotNull
    @Range(min = 0, max = 1, message = "撤单类型有误")
    private Integer cancelType;

    /**
     * 订单orderId
     */
    private String orderId;

    /**
     * 订单spotTransId
     */
    private Long spotTransId;

    /**
     * 来源（0-前台，1-机器人 2 后台管理）
     */
    private Integer source;

    /**
     * 后台管理 测单人
     */
    private Long adminId;
}
