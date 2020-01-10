package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExchangeAccountAddrReqDto extends ReqData {

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
     * 币种名称
     */
    private String coinName;
    /**
     * 充币地址
     */
    private String addr;

    private String createBy;

    private Date createTime;

    /**
     * 针对USDT
     */
    private String coinNameChild;

    /**
     * eos标签
     */
    private String eosMemo;

}
