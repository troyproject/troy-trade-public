package com.troy.trade.service.foreign;

import com.troy.futures.exchange.api.service.AccountFuturesExchangeApi;
import com.troy.margin.exchange.api.service.AccountMarginExchangeApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 */
@FeignClient(qualifier = "accountFuturesExchangeClient", name = "${troy.marginExchange.serviceName}")
public interface AccountMarginExchangeClient extends AccountMarginExchangeApi {

}
