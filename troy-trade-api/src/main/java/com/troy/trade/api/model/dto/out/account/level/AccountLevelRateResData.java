package com.troy.trade.api.model.dto.out.account.level;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Han
 * @date 2019/08/16
 */
@Setter
@Getter
public class AccountLevelRateResData extends ResData {

    private static final long serialVersionUID = 299623212151223161L;


    @ApiModelProperty(value = "当前交易量与所需交易量百分比")
    private Double tradingVolumePercentage;
    @ApiModelProperty(value = "当前持有量与所需持有量百分比")
    private Double troyBalancePercentage;


}

