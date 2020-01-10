package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminExcessTurnInfoReqDto extends ReqData {

    /**
     * 交易所账户ID
     */
    private Long exchAcctId;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 清算批次ID
     */
    private String exchAcctClearTimeId;

}
