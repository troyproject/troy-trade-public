package com.troy.trade.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author zhangchengjie
 * @date 2019/09/19
 */
@Configuration
public class AccountCoinConfig {

    @Bean("usdtChainMap")
    public HashMap<String, String> usdtChain() {
        HashMap<String, String> usdtChainMap = new HashMap<>(16);
        usdtChainMap.put("omni", "USDT");
        usdtChainMap.put("ETH", "USDT-ERC20");
        return usdtChainMap;
    }

}
