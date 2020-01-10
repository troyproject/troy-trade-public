package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * 提币详情
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsExtractApplyInfoResData extends ResData {

    @ApiModelProperty(value = "账户币种id")
    private Long accountCoinId;

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "可用额")
    private BigDecimal usableAmount;

    @ApiModelProperty(value = "冻结额")
    private BigDecimal frozenAmount;

    @ApiModelProperty(value = "手续费比率")
    private BigDecimal feeRate;

    @ApiModelProperty(value = "最小提现数量")
    private BigDecimal withdrawsLeast;

    @ApiModelProperty(value = "历史提现地址数组")
    private List<String> historyAddrs;



}

