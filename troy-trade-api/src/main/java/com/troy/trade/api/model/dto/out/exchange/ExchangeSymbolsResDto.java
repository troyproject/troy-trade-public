package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易对列表查询返回实体
 *
 * @author caq
 * @date 2019/10/16
 */
@Setter
@Getter
public class ExchangeSymbolsResDto extends ResData {

    private String exchSymbolId;
    /**
     * 币种
     */
    private String exchCode;

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 最小成交额
     */
    private BigDecimal quoteLeast;

    private String quoteLeastFormat;

    /**
     * 数量精度,如1
     */
    private Integer basePrecision;

    /**
     * 价格精度,如1
     */
    private Integer quotePrecision;

    /**
     * 最小成交量
     */
    private BigDecimal baseLeast;

    private String baseLeastFormat;

    /**
     * 是否交易
     */
    private Integer status;

    private Date createTime;

    private Integer weight;

}