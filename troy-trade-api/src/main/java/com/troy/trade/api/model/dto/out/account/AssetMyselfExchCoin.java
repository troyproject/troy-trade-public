package com.troy.trade.api.model.dto.out.account;

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
public class AssetMyselfExchCoin {
    @ApiModelProperty(value = "交易所币种id")
    private String exchangeCoinId;
    @ApiModelProperty(value = "交易所币种名称")
    private String name;
    @ApiModelProperty(value = "最小充币数量")
    private BigDecimal depositsLeast;
}
