package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class ExchangeTransferRecordsReqDto extends ReqPage {

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

    private Date startTime;
    private Date endTime;

    private Date startCheckTime;
    private Date endCheckTime;

    private String createBy;
    /**
     * 实际到账数量
     */
    private BigDecimal actualAmount;

    /**
     * 转提币主键ID
     */
    private Long accountCoinTellerId;
}
