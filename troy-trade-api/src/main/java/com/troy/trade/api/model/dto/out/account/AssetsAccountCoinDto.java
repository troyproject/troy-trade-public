package com.troy.trade.api.model.dto.out.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author zhangchengjie
 * @date 2019/08/19
 */
@Setter
@Getter
public class AssetsAccountCoinDto {

    @ApiModelProperty(value = "账户币种id")
    private Long accountCoinId;

    @ApiModelProperty(value = "交易所币种id")
    private String exchangeCoinId;

    @ApiModelProperty(value = "账户币种名称")
    private String accountCoinName;

    @ApiModelProperty(value = "账户币种总额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "账户币种可用额")
    private BigDecimal usableAmount;

    @ApiModelProperty(value = "账户币种冻结额")
    private BigDecimal frozenAmount;

    @ApiModelProperty(value = "资产折合BTC")
    private BigDecimal BTCAmount;

    @ApiModelProperty(value = "资产折合CNY")
    private BigDecimal CNYAmount;

    @ApiModelProperty(value = "资产折合USDT")
    private BigDecimal USDTAmount;


    @ApiModelProperty(value = "币种操作状态，0-不可提币不可充币、1-可提币可充币、2-只可提币、3-只可充币")
    private Integer operationStatus;

    @ApiModelProperty(value = "转币状态，0-不可转，1-可转")
    private Integer transferStatus;

    /**
     * 币种精度
     */
    private Integer showPrecision;

    public AssetsAccountCoinDto() {
        this.totalAmount = BigDecimal.ZERO;
        this.usableAmount = BigDecimal.ZERO;
        this.frozenAmount = BigDecimal.ZERO;
        this.BTCAmount = BigDecimal.ZERO;
        this.CNYAmount = BigDecimal.ZERO;
    }

}
