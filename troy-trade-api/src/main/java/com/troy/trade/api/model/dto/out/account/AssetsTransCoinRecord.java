package com.troy.trade.api.model.dto.out.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 转币历史记录
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsTransCoinRecord implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "转币记录Id")
    private Long accountCoinTransRecordId;

    @ApiModelProperty(value = "转出账户名称")
    private String outAccountName;

    @ApiModelProperty(value = "转出交易所code")
    private String outExchCode;

    @ApiModelProperty(value = "转入账户名称")
    private String inAccountName;

    @ApiModelProperty(value = "转入交易所code")
    private String inExchCode;

    @ApiModelProperty(value = "币种名称")
    private String coinName;

    @ApiModelProperty(value = "转出数量")
    private java.math.BigDecimal transAmount;

    @ApiModelProperty(value = "到账数量")
    private java.math.BigDecimal entryAmount;

    @ApiModelProperty(value = "转账时间")
    private java.util.Date createTime;

    @ApiModelProperty(value = "状态 （0失败 1成功）")
    private Integer status;

}

