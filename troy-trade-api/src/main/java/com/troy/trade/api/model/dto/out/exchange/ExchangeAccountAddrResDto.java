package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExchangeAccountAddrResDto extends ResData {

    private Long exchAcctAddrId;

    /**
     * 交易所账户ID
     */
    private Long exchAcctId;

    /**
     * 交易所CODE
     */
    private String exchCode;

    /**
     * 币种
     */
    private String coinName;

    /**
     * 充币地址
     */
    private String addr;

    private String createBy;

    private Date createTime;

    private String eosMemo;


}
