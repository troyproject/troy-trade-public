package com.troy.trade.service.foreign;

import com.troy.trade.exchange.api.service.TradeExchangeApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 交易所调用服务
 *
 * @author dp
 */
@FeignClient(qualifier = "tradeExchangeClient", name = "${troy.exchange.serviceName}")
public interface TradeExchangeClient extends TradeExchangeApi {

}
