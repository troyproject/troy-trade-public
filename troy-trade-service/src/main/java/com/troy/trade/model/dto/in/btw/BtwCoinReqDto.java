package com.troy.trade.model.dto.in.btw;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易所账户清算参数实体
 * @author yanping
 */
@Getter
@Setter
public class BtwCoinReqDto extends ReqData {

    /**
     * 币种名称
     */
    private String name;
}
