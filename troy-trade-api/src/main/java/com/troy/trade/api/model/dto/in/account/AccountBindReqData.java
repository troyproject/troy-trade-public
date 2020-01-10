package com.troy.trade.api.model.dto.in.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountBindReqData extends AccountRegisterReqData {

    private static final long serialVersionUID = 2996290991542350161L;

    private String apiKey;
    private String apiSecret;
    private String ip;
}
