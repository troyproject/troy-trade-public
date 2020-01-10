package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户币种详情
 *
 * @author zhangchengjie
 * @date 2019/08/19
 */
@Setter
@Getter
public class AssetsAccountCoinInfoResData extends ResData {

    @ApiModelProperty(value = "总资产折合BTC")
    private BigDecimal totalBTCAmount;

    @ApiModelProperty(value = "总资产折合CNY")
    private BigDecimal totalCNYAmount;

    @ApiModelProperty(value = "总资产折合USDT")
    private BigDecimal totalUSDTAmount;

    @ApiModelProperty(value = "账户币种列表")
    private List<AssetsAccountCoinDto> accountCoinList;

    public AssetsAccountCoinInfoResData() {
        totalBTCAmount = BigDecimal.ZERO;
        totalCNYAmount = BigDecimal.ZERO;
        totalUSDTAmount = BigDecimal.ZERO;
    }

}
