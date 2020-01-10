package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsTransCoinReqData extends ReqData {

    @JsonIgnore
    private Long userId;

    @ApiModelProperty(value = "转出账户币种id")
    private Long outAccountCoinId;

    @ApiModelProperty(value = "转出账户id")
    private Long outAccountId;

    @ApiModelProperty(value = "转入账户id")
    private Long inAccountId;

//    @ApiModelProperty(value = "转入交易所code")
//    private String inExchCode;
//
//    @ApiModelProperty(value = "转入账户名称")
//    private String inAccountName;

    @ApiModelProperty(value = "转出数量")
    private BigDecimal transAmount;

    @JsonIgnore
    private BigDecimal feeAmount;

    @ApiModelProperty(value = "链名称")
    private String chainName;

}
