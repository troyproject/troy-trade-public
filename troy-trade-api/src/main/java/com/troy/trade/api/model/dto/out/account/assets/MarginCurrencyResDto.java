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
public class MarginCurrencyResDto extends ResData {

    /**
     * 币种名称
     */
    private String coin;

    /**
     * 可用于交易数量
     */
    private BigDecimal available;

    /**
     * 冻结(不可用)
     */
    private BigDecimal hold;

    /**
     * 已借币 （已借未还的部分）
     */
    private BigDecimal borrowed;

    /**
     * btc估值
     */
    private BigDecimal btc;

    /**
     * usdt估值
     */
    private BigDecimal usdt;

    public MarginCurrencyResDto() {
        super();
    }

    public MarginCurrencyResDto(String coin, BigDecimal available, BigDecimal hold, BigDecimal borrowed) {
        this.coin = coin;
        this.available = available;
        this.hold = hold;
        this.borrowed = borrowed;
    }

    public static MarginCurrencyResDto getInstance(String coin, BigDecimal available, BigDecimal hold, BigDecimal borrowed){
        return new MarginCurrencyResDto(coin, available, hold, borrowed);
    }
}
