package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminExchangeCoinReqDto extends ReqPage {

    /**
     * 交易所编码
     */
    private String exchCode;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 币种状态，0-不可用、1-可用
     */
    private Integer status;

    /**
     * 交易所币种ID
     */
    private String exchangeCoinId;

}
