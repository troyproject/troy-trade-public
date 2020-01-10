package com.troy.trade.configurator.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * btw钱包充提币配置
 *
 * @author zhangchengjie
 * @date 2019/09/03
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "troy.wallet.btw")
public class WalletBTWProperties {

    private String host;

    private String openKey;

    private String openSecret;

    private String system;

    private String bname;

    private List<String> accessIps;

    /**
     * 交易所提币业务名称
     */
    private String exchBname;

}
