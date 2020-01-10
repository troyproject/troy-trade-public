package com.troy.trade.api.model.dto.out.account.auth;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountAuthListResData extends ResData {

    private static final long serialVersionUID = 2996290941542041161L;

    private List<AccountAuthListDetails> list;

    public AccountAuthListResData() {

    }

    public AccountAuthListResData(List<AccountAuthListDetails> list) {
        this.list = list;
    }
}
