package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * 合约交易对列表查询返回实体
 *
 * @date 2019/12/13
 */
@Setter
@Getter
public class ExchangeFuturesSymbolResDto extends ResData {

    private String exchSymbolId;

    private String nowPrice;

    private String priceChangePercent;

    private String cnyPrice;

    private String cny24h;

    private String usdtPrice;//价格转USDT后的金额

    private String usdt24h;//24小时成交量转USDT后的金额

    private String volume24h;

    private String symbol;

    private String highPrice;//最高价
    private String lowPrice;//最低价

    //本周 this_week 次周 next_week  季度 quarter
    private String alias;

    /**
     * 交易所原始合约ID
     */
    private String tradeSymbol;

    /**
     * 合约面值
     */
    private String contractVal;

}
