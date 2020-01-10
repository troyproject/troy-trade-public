package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AdminExchAcctWithdrawReqDto extends ReqData {
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 提现账户ID
     */
    private Long exchAcctId;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 提现总个数
     */
    private BigDecimal totalAmount;

    /**
     * 实际到账个数
     */
    private BigDecimal receivedAmount;
}
