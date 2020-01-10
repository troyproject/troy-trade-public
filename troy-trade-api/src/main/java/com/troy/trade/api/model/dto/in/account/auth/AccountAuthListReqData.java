package com.troy.trade.api.model.dto.in.account.auth;

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
public class AccountAuthListReqData extends ReqData {

    private static final long serialVersionUID = 2996290941542051161L;

    private String accountName;
    /**
     * @see com.troy.trade.api.model.constant.YesOrNo
     */
    private Integer status;
}
