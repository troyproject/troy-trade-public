package com.troy.trade.assets;

import org.springframework.context.ApplicationEvent;

/**
 * 账户币种日志记录事件
 *
 * @author zhangchengjie
 * @date 2019/08/20
 */
public class AssetsCoinLogEvent extends ApplicationEvent {

    private Object source;

    public AssetsCoinLogEvent(Object source) {
        super(source);
        this.source = source;
    }
}
