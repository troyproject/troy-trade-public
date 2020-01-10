package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeCoinReqDto extends ReqData {

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 币种状态，0-不可用、1-可用
     */
    private Integer status;


}
