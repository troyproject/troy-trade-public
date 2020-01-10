package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 */
@Setter
@Getter
public class AccountBindDetails extends ResData{

    private static final long serialVersionUID = 299629099151223161L;

    private Long accountId;
    private Long accountBindId;
    private String exchangeCode;
    private String exchangeParentCode;
    private Integer accountType;
    private String accountName;
    private String exchangeName;

}
