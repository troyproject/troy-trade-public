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
public class AccountAuthCancelReqData extends ReqData {

    private static final long serialVersionUID = 299629325342350161L;

    private Long id;
}
