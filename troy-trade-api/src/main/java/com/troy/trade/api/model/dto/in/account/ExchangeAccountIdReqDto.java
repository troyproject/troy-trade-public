package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeAccountIdReqDto extends ReqData {

    /**
     * 交易所code
     */
    private String exchCode;

}
