package com.troy.trade.model.dto.out;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author zhangchengjie
 * @date 2019/08/27
 */
@Setter
@Getter
public class AssetsAmountCalculateResDto {
    /**
     * 总资产折合BTC
     */
    private BigDecimal totalBTCAmount;
    /**
     * 总资产折合CNY
     */
    private BigDecimal totalCNYAmount;

    /**
     * 总资产折合USDT
     */
    private BigDecimal totalUSDTAmount;
}
