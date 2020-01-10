package com.troy.trade;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * TroyTradeApplication
 *
 * @author
 */
@MapperScan("com.troy.trade.mapper")
@SpringBootApplication(scanBasePackages = "com.troy")
@EnableFeignClients(basePackages = {"com.troy.trade.exchange.api.service", "com.troy.trade.service.foreign", "com.troy.trade.ws.api.service"})
@EnableEurekaClient
@EnableHystrix
@EnableAsync
@EnableRetry
@EnableScheduling
@EnableTransactionManagement
public class TroyTradeApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(TroyTradeApplication.class, args);
    }
}
