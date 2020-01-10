package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易对列表查询返回实体
 *
 * @author yanping
 * @date 2019/08/16
 */
@Setter
@Getter
public class FavoriteSymbolResDto extends ResData {

    private String exchSymbolId;

    private String nowPrice;

    private String priceChangePercent;

    private String cnyPrice;

    private String cny24h;

    private String volume24h;

    private String symbol;

    private String exchCode;

    /**
     * 合约类型
     * @see com.troy.trade.api.model.constant.SymbolTypeEnum
     */
    private String symbolType;

    /**
     * 交易所类型
     * @see com.troy.commons.exchange.model.enums.ExchTypeEnum
     */
    private Integer exchType;

    /**
     * 交易所合约ID
     */
    private String tradeSymbol;
}
