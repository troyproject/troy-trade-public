package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author caq
 * @date 2019/10/17
 */
@Setter
@Getter
public class AssetsAccountExchCoinResDto extends ResData {

    @ApiModelProperty(value = "账户币种名称")
    private String accountCoinName;

    @ApiModelProperty(value = "账户币种btcAmount")
    private BigDecimal btcAmount;



}
