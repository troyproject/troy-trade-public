package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class ExchangeTransferRecordsResDto extends ResData {
    /**
     * 出交易所
     */
    private String exchCode;
    /**
     * 出账户
     */
    private Long accountId;
    /**
     * 币种
     */
    private String coinName;
    /**
     * 入交易所
     */
    private String entryExchCode;
    /**
     * 出账户
     */
    private Long entryAccountId;
    /**
     * 操作数量
     */
    private BigDecimal businessAmount;
    /**
     * 状态
     */
    private Integer status;
    private String txid;
    private String remark;
    private Date createTime;
    private Date updateTime;
}
