package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * 查询余额返回
 *
 * @author dp
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountSpotBalanceResDto extends ResData {

    private List<AccountBalanceResDto> accountBalanceResDto;

    @ApiModelProperty(value = "总资产折合BTC")
    private BigDecimal totalBTCAmount;

    @ApiModelProperty(value = "总资产折合USDT")
    private BigDecimal totalUSDTAmount;
}
