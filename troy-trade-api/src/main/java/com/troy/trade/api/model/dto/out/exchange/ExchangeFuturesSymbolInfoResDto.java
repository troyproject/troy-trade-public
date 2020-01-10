package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 */
@Getter
@Setter
public class ExchangeFuturesSymbolInfoResDto extends ResData {

    /**
     * 主键
     */
    private String exchFuturesSymbolId;
    /**
     * 交易所code
     */
    private String exchCode;
    /**
     * 货币种ID
     */
    private String baseCoinId;
    /**
     * 货币种名称
     */
    private String baseName;
    /**
     * 钱币种ID
     */
    private String quoteCoinId;
    /**
     * 钱币种名称
     */
    private String quoteName;
    /**
     * 交易对名称，如：BTC/USD
     */
    private String symbol;
    /**
     * 面值
     */
    private String contractVal;
    /**
     * 合约类型，如：this_week、next_week、quarter、swap
     */
    private String contractType;
    /**
     * 面值币种名称
     */
    private String contractValCoin;
    /**
     * 盈亏结算和保证金币种，如BTC
     */
    private String settlementCoin;
    /**
     * 最小成交量
     */
    private java.math.BigDecimal baseLeast;
    /**
     * 最小成交额
     */
    private java.math.BigDecimal quoteLeast;
    /**
     * 下单数量精度
     */
    private Integer basePrecision;
    /**
     * 下单价格精度
     */
    private Integer quotePrecision;
    /**
     * 是不是币本位保证金合约，0-不是、1-是
     */
    private Integer inverse;
    /**
     * 状态，0-禁用、1-启用
     */
    private Integer status;
    /**
     * 排序权重，数值越小越靠前
     */
    private Integer weight;
    /**
     * 备注
     */
    private String remark;

}
