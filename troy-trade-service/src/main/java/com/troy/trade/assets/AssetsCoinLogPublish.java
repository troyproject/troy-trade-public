package com.troy.trade.assets;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 资产币种变动日志事件Publish
 *
 * @author zhangchengjie
 * @date 2019/08/20
 */
@Component
public class AssetsCoinLogPublish implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(ApplicationEvent assetsCoinLogEvent) {
        applicationEventPublisher.publishEvent(assetsCoinLogEvent);
    }
}
