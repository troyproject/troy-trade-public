package com.troy.trade.api.model.dto.out.account.assets;


import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 合约账户查询余额返回
 */
@Setter
@Getter
public class MarginBalanceResDto extends ResData {

    /**
     * 系统币对名称
     */
    private String symbol;
    /**
     * 币余额
     */
    private MarginCurrencyResDto baseBalance;
    /**
     * 钱余额
     */
    private MarginCurrencyResDto quoteBalance;

    /**
     * btc估值
     */
    private BigDecimal btc;

    /**
     * usdt估值
     */
    private BigDecimal usdt;

    public MarginBalanceResDto() {
        super();
    }

    public MarginBalanceResDto(String symbol, MarginCurrencyResDto baseBalance, MarginCurrencyResDto quoteBalance) {
        this.symbol = symbol;
        this.baseBalance = baseBalance;
        this.quoteBalance = quoteBalance;
    }

}
