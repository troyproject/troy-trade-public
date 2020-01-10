package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeTypeResDto extends ReqData {

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 交易所类型
     */
    private Integer exchType;


}
