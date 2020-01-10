package com.troy.trade.model.enums;

import java.util.HashSet;
import java.util.Set;

/**
 * USDT币种名称枚举
 *
 * @author zhangchengjie
 * @date 2019/08/19
 */
public enum USDTCoinNameEnum {

    OMNI("USDT-OMNi","USDT","USDT"),
    ERC20("USDT-ERC20","USDT-ERC20","ETH");

    private String coinName;
    private String btwCoinName;
    private String newAddressCoinName;

    USDTCoinNameEnum(String coinName, String btwCoinName, String newAddressCoinName) {
        this.coinName = coinName;
        this.btwCoinName = btwCoinName;
        this.newAddressCoinName = newAddressCoinName;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getBtwCoinName() {
        return btwCoinName;
    }

    public void setBtwCoinName(String btwCoinName) {
        this.btwCoinName = btwCoinName;
    }

    public String getNewAddressCoinName() {
        return newAddressCoinName;
    }

    public void setNewAddressCoinName(String newAddressCoinName) {
        this.newAddressCoinName = newAddressCoinName;
    }

    public static Set<String> getCoinNames() {
        USDTCoinNameEnum[] usdtCoinNameEnums = USDTCoinNameEnum.values();
        Set<String> coinNames = new HashSet<>(2);
        for (USDTCoinNameEnum usdtCoinNameEnum : usdtCoinNameEnums) {
            coinNames.add(usdtCoinNameEnum.getCoinName());
        }
        return coinNames;
    }

    public static final Set<String> coinNames = getCoinNames();
}
