package com.troy.trade.model.dto.out.report;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeAccountResDto extends ResData {

    /**
     * 交易所账户主键ID
     */
    private Long exchAcctId;

    /**
     * 交易所CODE
     */
    private String exchCode;
}
