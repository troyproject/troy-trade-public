package com.troy.trade.api.model.dto.out.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class WalletCoinAmountDto implements Serializable {

    /**
     * 金额
     */
    private String amount;

    /**
     * 币种英文
     */
    private String coinName;

}
