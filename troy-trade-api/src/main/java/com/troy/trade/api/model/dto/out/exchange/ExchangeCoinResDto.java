package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 交易所列表所有字段返回
 *
 * @author dp
 */
@Setter
@Getter
public class ExchangeCoinResDto extends ResData {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private String exchangeCoinId;

    /**
     * 交易所code
     */

    private String exchCode;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 币种别名
     */
    private String aliasName;

    /**
     * 充币地址
     */
    private String depositAddress;

    /**
     * 最小提币数量
     */
    private BigDecimal withdrawsLeast;

    /**
     * 交易所最小提币数量
     */
    private BigDecimal exchWithdrawsLeast;

    /**
     * 提币手续费收取方式：1-按量、2-按比例
     */
    private Integer withdrawsFeeType;

    /**
     * 提币手续费
     */
    private BigDecimal withdrawsFee;

    /**
     * 交易所提币手续费
     */
    private BigDecimal exchWithdrawsFee;

    /**
     * 充提币精度
     */
    private Integer operationPrecision;

    /**
     * 币种显示精度
     */
    private Integer showPrecision;

    /**
     * 入账确认数
     */
    private Integer bookedConfirmNum;

    /**
     * 最终确认数
     */
    private Integer finalConfirmNum;

    /**
     * 单日最大提出笔数
     */
    private Integer maxWithdrawsTimeDay;

    /**
     * 单日最大转账数量
     */
    private BigDecimal maxTransferDay;

    /**
     * 币种可操作状态，0-不可提币不可充币、1-可提币可充币、2-只可提币、3-只可充币
     */
    private Integer operationStatus;

    /**
     * 币种状态，0-不可用、1-可用
     */
    private Integer status;



}
