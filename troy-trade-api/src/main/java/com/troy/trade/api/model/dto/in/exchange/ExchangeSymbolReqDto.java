package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 交易对查询参数实体
 *
 * @author caq
 * @date 2019/10/08
 */
@Setter
@Getter
public class ExchangeSymbolReqDto extends ReqPage {

    private String exchSymbolId;

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
     * 是否交易
     */
    private Integer status;

    /**
     * 更新-权重
     */
    private Integer weight;

    /**
     * 是否是计价货币
     */
    private Integer priceStatus;

    /**
     * 最小成交额
     */
    private BigDecimal baseLeast;

    /**
     * 数量精度,如1
     */
    private Integer basePrecision;

    /**
     * 价格精度,如1
     */
    private Integer quotePrecision;

    /**
     * 最小成交数量
     */
    private BigDecimal quoteLeast;

}