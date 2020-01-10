package com.troy.trade.service.foreign;

import com.troy.trade.exchange.api.service.AccountExchangeApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(qualifier = "accountExchangeClient", name = "${troy.exchange.serviceName}")
public interface AccountExchangeClient extends AccountExchangeApi {

}
