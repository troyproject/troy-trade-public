package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 */
@Setter
@Getter
public class AccountBindBalanceReqData extends ReqData{

    private static final long serialVersionUID = 1L;

    private Long accountId;
    private Long accountBindId;
    private Long userId;
    private String exchCode;

}
