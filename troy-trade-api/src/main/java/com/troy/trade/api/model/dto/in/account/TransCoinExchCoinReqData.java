package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransCoinExchCoinReqData extends ReqData {

    private String exchCode;

    private String coinName;

}
