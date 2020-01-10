package com.troy.trade.api.model.dto.out.account.level;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Han
 * @date 2019/08/16
 */
@Setter
@Getter
public class AccountLevelResData extends ResData {

    private static final long serialVersionUID = 299623212151223161L;

    @ApiModelProperty(value = "当前级别（与交易级别相同，取自BTC交易量或Troy持有量中级别最高的一个）")
    private Integer currentLevel;
    @ApiModelProperty(value = "下一个级别")
    private Integer nextLevel;
    @ApiModelProperty(value = "当前30天内交易量")
    private BigDecimal currentTradingVolume;
    @ApiModelProperty(value = "达到下一级别所需交易量")
    private BigDecimal targetTradingVolume;
    @ApiModelProperty(value = "当前交易量与所需交易量百分比")
    private Double tradingVolumePercentage;
    @ApiModelProperty(value = "按交易量算的当前级别")
    private Integer currentTradingVolumeLevel;
    @ApiModelProperty(value = "按交易量算的下一级别")
    private Integer nextTradingVolumeLevel;
    @ApiModelProperty(value = "当前Troy持有量")
    private BigDecimal currentTroyBalance;
    @ApiModelProperty(value = "达到下一级别所需持有量")
    private BigDecimal targetTroyBalance;
    @ApiModelProperty(value = "当前持有量与所需持有量百分比")
    private Double troyBalancePercentage;
    @ApiModelProperty(value = "按持有量算的当前级别")
    private Integer currentTroyBalanceLevel;
    @ApiModelProperty(value = "按持有量算的下一级别")
    private Integer nextTroyBalanceLevel;
}

