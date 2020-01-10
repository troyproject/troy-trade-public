package com.troy.trade.service.foreign;

import com.troy.user.api.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Han
 */
@FeignClient(qualifier = "userClient", name = "${troy.user.serviceName}")
public interface UserClient extends UserApi {

}
