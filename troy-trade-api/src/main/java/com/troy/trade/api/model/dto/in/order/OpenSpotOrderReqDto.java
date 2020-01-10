package com.troy.trade.api.model.dto.in.order;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 挂单币币订单入参
 *
 * @author dp
 */
@Setter
@Getter
public class OpenSpotOrderReqDto extends ReqData {



    /**
     * 当前账户ID
     */
    @NotNull(message = "当前账户ID不能为空")
    private Long accountId;


    /**
     * 交易对ID
     */
    @NotNull(message = "交易对ID不能为空")
    private Long exchSymbolId;


}
