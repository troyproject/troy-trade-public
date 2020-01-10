package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 交易对列表查询返回实体
 *
 * @author yanping
 * @date 2019/08/16
 */
@Setter
@Getter
public class ExchangeSymbolListResDto extends ResData {

    /**
     * 所有
     */
    private Map<String,List<ExchangeSymbolResDto>> exchangeSymbolInfo;
}