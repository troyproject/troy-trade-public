package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminExchAcctWithdrawResDto extends ResData {
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 提现成功ID
     */
    private String withdrawId;
}
