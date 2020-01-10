package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 交易对列表查询返回实体
 *
 * @author
 * @date 2019/12/13
 */
@Setter
@Getter
public class ExchangeFuturesSymbolListResDto extends ResData {

    private Map<String,List<ExchangeFuturesSymbolResDto>> exchangeSymbolInfo;
}