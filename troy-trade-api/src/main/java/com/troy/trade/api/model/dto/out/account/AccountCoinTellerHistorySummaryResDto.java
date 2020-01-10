package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AccountCoinTellerHistorySummaryResDto extends ResData {

    private Long accountId;

    private String coinName;


    private Integer operType;

    private BigDecimal businessAmount;

    private BigDecimal actualAmount;

    private BigDecimal totalAmount;


}
