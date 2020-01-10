package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminExchangeAccountResDto extends ResData {

    private Long exchAcctId;

    private String exchAcctName;
    /**
     * 交易所CODE
     */
    private String exchCode;
}
