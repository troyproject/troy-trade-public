package com.troy.trade.api.model.dto.out.account.assets;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Han
 * @date 2019/08/16
 */
@Setter
@Getter
public class AccountAssetsResData extends ResData {

    private static final long serialVersionUID = 299629462151223161L;

    private List<AccountAssetsDetails> list;
    private BigDecimal totalAmountBtc;
    private BigDecimal totalAmountCny;
}

