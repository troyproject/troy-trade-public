package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountBindDetailsResData extends ResData {

    private static final long serialVersionUID = 2996294331542350161L;

    private Long accountBindId;
    private String apiKey;
    private String ip;
}
