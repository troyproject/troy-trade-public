package com.troy.trade.assets;

import com.troy.trade.service.IAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 资产币种变动日志事件Listener
 *
 * @author zhangchengjie
 * @date 2019/08/20
 */
@Component
public class AssetsCoinLogListener implements ApplicationListener<AssetsCoinLogEvent> {

    @Autowired
    private IAssetsService assetsService;

    @Override
    public void onApplicationEvent(AssetsCoinLogEvent assetsCoinLogEvent) {
        assetsService.handleModifyAccountCoinAmountLog(assetsCoinLogEvent);
    }
}
