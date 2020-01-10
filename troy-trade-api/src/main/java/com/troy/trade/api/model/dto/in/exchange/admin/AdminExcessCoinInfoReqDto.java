package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminExcessCoinInfoReqDto extends ReqPage {


    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 清算批次ID
     */
    private String exchAcctClearTimeId;

}
