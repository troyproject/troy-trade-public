package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 合约交易对详情查询参数实体
 *
 * @date 2019/12/16
 */
@Setter
@Getter
public class ExchangeFuturesSymbolDetailReqDto extends ExchangeSymbolDetailReqDto {

    /**
     * this_week
     * next_week
     * quarter
     */
    private String alias;

}