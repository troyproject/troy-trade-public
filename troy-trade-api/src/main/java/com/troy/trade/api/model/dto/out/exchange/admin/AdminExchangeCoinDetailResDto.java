package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 币种列表字段返回
 *
 * @author yanping
 */
@Setter
@Getter
public class AdminExchangeCoinDetailResDto extends ResData {

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
    private String withdrawsLeast;

    /**
     * 交易所最小转币数量
     */
    private String transferLeast;

    /**
     * 手续费收取方式：1-按量、2-按比例
     */
    private Integer withdrawsFeeType;

    /**
     * 提币手续费
     */
    private String withdrawsFee;

    /**
     * 转币手续费
     */
    private String transferCoinFee;

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
    private String maxTimeWidwalUnverf;

    /**
     * 未认证，单日提现最大额度
     */
    private String maxDayWidwalUnverf;

    /**
     * 已认证，单笔提现最大额度
     */
    private String maxTimeWidwalVerf;

    /**
     * 已认证，单日提现最大额度
     */
    private String maxDayWidwalVerf;

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
