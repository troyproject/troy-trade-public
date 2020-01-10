package com.troy.trade.model.dto.in.report;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易所账户清算参数实体
 * @author yanping
 */
@Getter
@Setter
public class ExchAcctClearReqDto extends ReqData {

    /**
     * 清算批次ID
     */
    private String exchAcctClearTimeId;

    /**
     * 平台账户ID
     */
    private Long exchAcctId;
}
