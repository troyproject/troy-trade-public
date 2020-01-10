package com.troy.trade.model.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 账户交易所余额
 *
 * @author dp
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceOfExchangeReq {

    /**
     * 交易所账户ID
     */
    private Long exchAcctId;

    /**
     * 绑定账户表ID
     */
    private Long acctBindId;

}
