package com.troy.trade.util;

import com.troy.trade.model.enums.USDTCoinNameEnum;

/**
 * @author zhangchengjie
 */
public class USDTCoinNameUtil {

    public static String convertNewAddrCoinName(String coinName) {
        if (coinName.equals(USDTCoinNameEnum.OMNI.getCoinName())) {
            return USDTCoinNameEnum.OMNI.getNewAddressCoinName();
        } else if(coinName.equals(USDTCoinNameEnum.ERC20.getCoinName())) {
            return USDTCoinNameEnum.ERC20.getNewAddressCoinName();
        } else {
            return coinName;
        }
    }

    public static String convertBtw2Troy(String coinName) {
        if (coinName.equals(USDTCoinNameEnum.OMNI.getBtwCoinName())) {
            return USDTCoinNameEnum.OMNI.getCoinName();
        } else if(coinName.equals(USDTCoinNameEnum.ERC20.getBtwCoinName())) {
            return USDTCoinNameEnum.ERC20.getCoinName();
        } else {
            return coinName;
        }
    }

    public static String convertTroy2Btw(String coinName) {
        if (coinName.equals(USDTCoinNameEnum.OMNI.getCoinName())) {
            return USDTCoinNameEnum.OMNI.getBtwCoinName();
        } else if(coinName.equals(USDTCoinNameEnum.ERC20.getCoinName())) {
            return USDTCoinNameEnum.ERC20.getBtwCoinName();
        } else {
            return coinName;
        }
    }

}
