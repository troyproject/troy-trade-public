package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeResDto extends ResData {

    private String code;
    private String name;
    private String aliasName;
    private Integer exchType;
}
