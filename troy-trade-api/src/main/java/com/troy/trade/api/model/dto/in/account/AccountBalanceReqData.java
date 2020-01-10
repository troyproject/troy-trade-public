package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 */
@Setter
@Getter
public class AccountBalanceReqData extends ReqData {

    private Integer accountId;

    private Integer exchType;
}
