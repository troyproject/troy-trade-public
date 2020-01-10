package com.troy.trade.api.model.dto.out.account;

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
public class AccountListResData extends ResData {

    private static final long serialVersionUID = 2996290991512350161L;

    private List<AccountDetails> list;

    public AccountListResData() {

    }

    public AccountListResData(List<AccountDetails> list) {
        this.list = list;
    }
}