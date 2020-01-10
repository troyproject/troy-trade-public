package com.troy.trade.service.foreign;

import com.troy.futures.exchange.api.service.TradeFuturesExchangeApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 交易所调用账户服务
 *
 * @author dp
 */
@FeignClient(qualifier = "tradeFuturesExchangeClient", name = "${troy.futuresExchange.serviceName}")
public interface TradeFuturesExchangeClient extends TradeFuturesExchangeApi {

}
