package com.troy.trade.api.model.dto.out.exchange;


import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class ExchangeTransferRecordsRes  extends ResData {


    private Long id;
    private String exchCode;
    private Long accountId;
    private String coinName;
    private String entryExchCode;
    private Long entryAccountId;
    private BigDecimal businessAmount;
    private Integer status;
    private String txid;
    private String remark;
    private Date createTime;
    private Date updateTime;

}
