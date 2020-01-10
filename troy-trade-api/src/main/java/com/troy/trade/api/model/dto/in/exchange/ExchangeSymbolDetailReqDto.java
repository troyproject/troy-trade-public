package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 交易对详情查询参数实体
 *
 * @author yanping
 * @date 2019/08/16
 */
@Setter
@Getter
public class ExchangeSymbolDetailReqDto extends ReqData {

    /**
     * 交易所code
     */
    @NotNull(message = "必填参数为空")
    private String exchCode;

    /**
     * 交易对名称
     */
    @NotNull(message = "必填参数为空")
    private String symbol;

    /**
     * this_week
     * next_week
     * quarter
     * swap
     */
    private String alias;

}