package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeParentResDto extends ResData {

    private String exchangeParentCode;
    private String exchangeParentName;
    private String aliasName;
    private String icon;

}
