package com.troy.trade.configurator;

import com.troy.trade.configurator.interceptor.ShardTableInterceptor;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * mybatis config
 *
 * @author zhangchengjie
 * @date 2019/08/23
 */
//@Configuration
@Deprecated
public class MyBatisConfiguration {

    @Bean
    public ShardTableInterceptor shardTableInterceptor() {
        ShardTableInterceptor shardTableInterceptor = new ShardTableInterceptor();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        shardTableInterceptor.setProperties(properties);
        return shardTableInterceptor;
    }

}
