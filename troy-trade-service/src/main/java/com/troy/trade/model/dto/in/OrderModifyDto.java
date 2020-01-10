package com.troy.trade.model.dto.in;

import com.troy.trade.model.domain.order.SpotTransPendingModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 订单修改DTO
 * @author dp
 */
@EqualsAndHashCode(callSuper = true)
public class OrderModifyDto extends SpotTransPendingModel {


    /**
     * 交易费用
     */
    @ApiModelProperty(value = "dealFee" ,name = "交易费用", example = "交易费用:10000.092839")
    private BigDecimal dealFee;

    private boolean needPush;

    public BigDecimal getDealFee() {
        return dealFee;
    }

    public void setDealFee(BigDecimal dealFee) {
        this.dealFee = dealFee;
    }

    public boolean isNeedPush() {
        return needPush;
    }

    public void setNeedPush(boolean needPush) {
        this.needPush = needPush;
    }
}
