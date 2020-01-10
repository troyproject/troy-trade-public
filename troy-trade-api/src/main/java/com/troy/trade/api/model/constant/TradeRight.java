package com.troy.trade.api.model.constant;

/**
 * description 是与否
 *
 * @author Han
 * @date 2018/10/8 10:08
 */
public enum TradeRight {

    /**
     * 否
     */
    canTrade(1),
    /**
     * 是
     */
    canTrans(2),
    canWithdraw(3),
    canDeposit(4);

    private int code;

    TradeRight(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


}
