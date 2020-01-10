package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 */
@Getter
@Setter
public class ExchangeParentReqDto extends ReqData {

    /**
     * 根据类型查交易所列表
     */
    private Integer bindAcctStatus;
}
