package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AdminExchangeBtwMutualTransferReqDto extends ReqPage {

    /**
     * 转出账户
     */
    private Long outExchAcctId;


    /**
     * 交易所账户ID
     */
    private Long exchAcctId;

    /**
     * 交易所编码'
     */
    private String exchCode;

    /**
     * 交易所账户名称'
     */
    private String exchAcctName;

    /**
     * '币种\n'
     */
    private String coinName;

    /**
     * 划转数量\n'
     */
    private BigDecimal amount;

    /**
     * '实际划转数量'
     */
    private BigDecimal receivedAmount;

    /**
     * '0交易所账户到钱包账户，1btw钱包账户到交易所账户'
     */
    private Integer directionType;

    /**
     * '状态，1-申请中、2-已完成、3-已取消、4-失败'
     */
    private Integer status;

    /**
     * '提现ID(交易所划转到钱包)'
     */
    private String withdrawId;

    /**
     * '交易号(交易所账户划转到btw账户之间交易ID)'
     */
    private String txid;

    /**
     * '外部充币唯一码'
     */
    private String outGuid;

    /**
     * '企业钱包充币唯一码(提币从BTW到交易所)'
     */
    private String guid;

    /**
     * ` varchar(255) DEFAULT NULL
     */
    private String remark;
}
