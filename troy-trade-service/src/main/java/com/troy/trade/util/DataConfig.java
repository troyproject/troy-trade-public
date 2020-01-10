package com.troy.trade.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * data相关参数
 *
 * @author yanping
 */
@Component
@ConfigurationProperties(prefix = "data")
public class DataConfig {

    private Map<String,List<String>> blockchainLargetransfer;//大额转账同步处理

    public Map<String, List<String>> getBlockchainLargetransfer() {
        return blockchainLargetransfer;
    }

    public void setBlockchainLargetransfer(Map<String, List<String>> blockchainLargetransfer) {
        this.blockchainLargetransfer = blockchainLargetransfer;
    }
}
