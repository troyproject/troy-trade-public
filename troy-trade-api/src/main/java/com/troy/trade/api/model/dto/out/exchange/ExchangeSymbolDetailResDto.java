package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易对详情查询返回实体
 *
 * @author yanping
 * @date 2019/08/16
 */
@Setter
@Getter
public class ExchangeSymbolDetailResDto extends ResData {

    private String symbol;
    /**
     * 最小成交量
     */
    private String baseLeast;
    /**
     * 最小成交额
     */
    private String quoteLeast;
    /**
     * 数量精度,如1
     */
    private Integer basePrecision;
    /**
     * 价格精度,如1
     */
    private Integer quotePrecision;

}