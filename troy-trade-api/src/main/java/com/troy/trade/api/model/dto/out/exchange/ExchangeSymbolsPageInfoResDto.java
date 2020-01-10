package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 交易对列表查询返回实体
 *
 * @author caq
 * @date 2019/10/16
 */
@Setter
@Getter
public class ExchangeSymbolsPageInfoResDto extends ResData {

    /**
     * 订单数据
     */
    private List<ExchangeSymbolsResDto> exchangeSymbols;
    /**
     * 总数量
     */
    private long total;
}