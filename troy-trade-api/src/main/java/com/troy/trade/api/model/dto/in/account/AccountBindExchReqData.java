package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 */
@Setter
@Getter
public class AccountBindExchReqData extends ReqData{

    private static final long serialVersionUID = 1L;

    private Integer accountOwnership;
    private String accountName;
    private Long accountId;
    private String exchangeParentCode;
    private String apiKey;
    private String apiSecret;
    private String exportIp;
    private String passphrase;
    private Long userId;


}
