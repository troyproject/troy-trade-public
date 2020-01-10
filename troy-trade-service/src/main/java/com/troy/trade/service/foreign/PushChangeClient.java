package com.troy.trade.service.foreign;

import com.troy.trade.ws.api.service.PushChangeApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(qualifier = "pushChangeClient", name = "${troy.ws.serviceName}")
public interface PushChangeClient extends PushChangeApi {

}
