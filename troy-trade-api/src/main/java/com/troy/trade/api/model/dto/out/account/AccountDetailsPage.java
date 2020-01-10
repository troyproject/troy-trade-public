package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountDetailsPage extends ResData  {

    private static final long serialVersionUID = 299629099151223161L;

    private List<AccountDetails> list;
    private  Long total;

}
