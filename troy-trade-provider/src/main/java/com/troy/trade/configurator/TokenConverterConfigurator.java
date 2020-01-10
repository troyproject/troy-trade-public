package com.troy.trade.configurator;

import com.troy.trade.configurator.properties.UserProperties;
import com.troy.user.client.auth.TokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * token 转换配置
 *
 * @author
 * @date 2018-10-25 下午3:59:05
 * @copyright
 */
@Configuration
public class TokenConverterConfigurator {

    @Autowired
    private UserProperties userProperties;

    /**
     * TODO 添加方法说明
     *
     * @return
     */
    @Bean
    TokenConverter TokenConverter() {
        TokenConverter tokenConverter = TokenConverter.builder().withPublicKey(this.userProperties.getPublicKey()).build();
        return tokenConverter;
    }
}
