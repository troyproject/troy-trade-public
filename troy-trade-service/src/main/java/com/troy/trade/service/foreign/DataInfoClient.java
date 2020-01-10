package com.troy.trade.service.foreign;

import com.troy.trade.exchange.api.service.DataInfoApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(qualifier = "dataInfoClient", name = "${troy.exchange.serviceName}")
public interface DataInfoClient extends DataInfoApi {
}
