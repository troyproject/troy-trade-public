package com.troy.trade.model.dto.out;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhangchengjie
 * @date 2019/09/04
 */
@Setter
@Getter
public class WalletQueryBillResDto {
    /**
     * BTW响应账单ID
     */
    private String btwBillId;
    /**
     * 币种名称
     */
    private String coinName;
    /**
     * 账单类型
     * (3000汇总成功 3001支付汇总%s手续费 4000打币成功 4001支付%s打币手续费)
     */
    private String billType;
    /**
     * 账单说明
     */
    private String billExplain;
    /**
     * 数量
     */
    private java.math.BigDecimal variation;
    /**
     * 来源地址
     */
    private String fromAddress;
    /**
     * 目标地址
     */
    private String toAddress;
    /**
     * 交易ID
     */
    private String txid;
    /**
     * 备注
     */
    private String remark;
    /**
     * 业务名称
     */
    private String bname;
    /**
     * 系统名称
     */
    private String system;
    /**
     * 创建时间
     */
    private Date createTime;
}
