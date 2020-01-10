package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeEditResDto extends ResData {

    private Long exchId;
    private String exchName;
    private String aliasName;
    private Integer status;
    private Integer sort;

}
