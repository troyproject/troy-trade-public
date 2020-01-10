package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sz
 */
@Setter
@Getter
public class UserIdReqData extends ReqData {

    private static final long serialVersionUID = 2996290231512350161L;

    private Long userId;

}
