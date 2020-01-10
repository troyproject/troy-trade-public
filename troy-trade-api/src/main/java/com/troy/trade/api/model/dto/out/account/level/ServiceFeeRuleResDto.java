package com.troy.trade.api.model.dto.out.account.level;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author caq
 * @date 2019/10/11
 */
@Setter
@Getter
public class ServiceFeeRuleResDto extends ResData {

    private Long feeRuleId;
    /**
     * 交易所
     */
    private String exchCode;

    /**
     * 等级
     */
    private Integer level;

    /**
     * block挂单手续费率
     */
    private String blockMakerRate;
    /**
     * block吃单手续费率
     */
    private String blockTakerRate;
}
