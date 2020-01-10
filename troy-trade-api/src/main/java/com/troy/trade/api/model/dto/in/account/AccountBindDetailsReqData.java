package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountBindDetailsReqData extends ReqData {

    private static final long serialVersionUID = 2996294341542350161L;

    private Long accountId;
    private Long userId;
}
