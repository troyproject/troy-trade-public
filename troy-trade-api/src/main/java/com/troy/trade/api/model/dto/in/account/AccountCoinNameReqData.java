package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sz
 * @date 2019/08/26
 */
@Setter
@Getter
public class AccountCoinNameReqData extends ReqData {


    private String accountCoinName;

}
