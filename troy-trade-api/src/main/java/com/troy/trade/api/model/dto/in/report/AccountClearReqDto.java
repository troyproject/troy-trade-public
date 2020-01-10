package com.troy.trade.api.model.dto.in.report;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountClearReqDto extends ReqData {

    /**
     * 要清算的交易所账户ID，当值为空时清算所有账户
     */
    private String exchAcctId;

}
