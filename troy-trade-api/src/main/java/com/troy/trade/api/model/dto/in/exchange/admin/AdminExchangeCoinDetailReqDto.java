package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 币种详情修改字段返回
 *
 * @author yanping
 */
@Setter
@Getter
public class AdminExchangeCoinDetailReqDto extends ReqData {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String exchangeCoinId;

    /**
     * 币种名称
     */
    private String name;

    /**
     * 最小提币数量
     */
    private BigDecimal withdrawsLeast;

    /**
     * 交易所最小转币数量
     */
    private BigDecimal transferLeast;

    /**
     * 提币手续费
     */
    private BigDecimal withdrawsFee;

    /**
     * 转币手续费
     */
    private BigDecimal transferCoinFee;

    /**
     * 充提币精度
     */
    private Integer operationPrecision;

    /**
     * 币种显示精度
     */
    private Integer showPrecision;

    /**
     * 未认证，单笔提现最大额度
     */
    private BigDecimal maxTimeWidwalUnverf;

    /**
     * 未认证，单日提现最大额度
     */
    private BigDecimal maxDayWidwalUnverf;

    /**
     * 已认证，单笔提现最大额度
     */
    private BigDecimal maxTimeWidwalVerf;

    /**
     * 已认证，单日提现最大额度
     */
    private BigDecimal maxDayWidwalVerf;

    /**
     * 最后操作时间
     */
    private Date updateTime;

    /**
     * 最后操作人
     */
    private String updateBy;

    /**
     * 最后修改人IP
     */
    private String lastUpdateFromIp;

    /**
     * 中文描述
     */
    private String chinese;

    /**
     * 英文描述
     */
    private String english;

    /**
     * 充币中文描述
     */
    private String depositChinese;

    /**
     * 充币英文描述
     */
    private String depositEnglish;

    /**
     * 转币中文描述
     */
    private String turnChinese;

    /**
     * 转币英文描述
     */
    private String turnEnglish;

}
