package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransCoinExchCoinResData extends ResData {

    private String exchangeCoinId;

}
