package com.troy.trade.api.model.dto.out.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRiskDetails {

    private Long accountId;
    private String exchangeCode;
    private Integer accountType;

}
