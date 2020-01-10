package com.troy.trade.api.model.dto.out.account.assets;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author sz
 */
@Setter
@Getter
public class AccountAssetsInfoDetails extends ResData {

    private static final long serialVersionUID = 299629099151223161L;

    private String exchangeCode;
    private String coinName;
    private String accountId;
    private Date createDate;
}
