package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 交易对列表查询返回实体
 *
 * @author yanping
 * @date 2019/08/16
 */
@Setter
@Getter
public class ExchangeSymbolResDto extends ResData {

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

}
