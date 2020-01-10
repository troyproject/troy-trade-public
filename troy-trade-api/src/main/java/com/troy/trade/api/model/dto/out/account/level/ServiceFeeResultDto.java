package com.troy.trade.api.model.dto.out.account.level;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author zhangchengjie
 * @date 2019/08/29
 */
@Setter
@Getter
public class ServiceFeeResultDto extends ResData {
    /**
     * 账户id
     */
    private Long accountId;
    /**
     * 手续费id
     */
    private Long feeLevelId;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 交易所挂单手续费率
     */
    private BigDecimal exchangeMakerRate;
    /**
     * 交易所吃单手续费率
     */
    private BigDecimal exchangeTakerRate;
    /**
     * block挂单手续费率
     */
    private BigDecimal blockMakerRate;
    /**
     * block吃单手续费率
     */
    private BigDecimal blockTakerRate;
}
