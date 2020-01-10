package com.troy.trade.service;

import com.troy.trade.model.enums.WalletNotifyTypeEnum;

/**
 * 通知Service
 *
 * @author zhangchengjie
 * @date 2019/08/16
 */
public interface INotifyService {

    boolean walletNotify(WalletNotifyTypeEnum walletNotifyTypeEnum);

}
