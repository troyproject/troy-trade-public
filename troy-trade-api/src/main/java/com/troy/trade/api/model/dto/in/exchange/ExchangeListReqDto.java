package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 根据交易所类型查找交易所信息
 */
@Getter
@Setter
public class ExchangeListReqDto extends ReqData {

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 交易所类型列表
     */
    private List<Integer> exchTypeList;
}
