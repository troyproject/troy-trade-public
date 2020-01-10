package com.troy.trade.api.model.dto.out.account.assets;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountAssetsDetails implements Serializable {

    private static final long serialVersionUID = 299629099151223161L;

    private String exchangeCode;
    private String coinName;
    private BigDecimal usableAmount;
    private BigDecimal totalAmount;
    private Integer showPrecision;
    private BigDecimal btcAmount;
}