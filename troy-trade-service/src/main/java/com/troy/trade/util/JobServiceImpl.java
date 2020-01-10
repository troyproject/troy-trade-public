package com.troy.trade.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<URI> serviceUrl(String serviceName) {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceName);
        List<URI> urlList = new ArrayList();
        if (!CollectionUtils.isEmpty(serviceInstanceList)) {
            serviceInstanceList.forEach(si -> urlList.add(si.getUri()));
        }
        return urlList;
    }

    public List<URI> defaultServiceUrl(){
        return serviceUrl(applicationName);
    }
}
