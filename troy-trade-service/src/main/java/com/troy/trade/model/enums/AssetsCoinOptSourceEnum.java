package com.troy.trade.model.enums;

import com.troy.trade.model.dto.in.AssetsCoinOpt;

/**
 * 账户币种操作来源
 *
 * @author zhangchengjie
 * @date 2019/08/19
 * @see AssetsCoinOpt
 */
public enum AssetsCoinOptSourceEnum {

    /**
     * 交易
     */
    trans(1),
    /**
     * 充币
     */
    Recharge(2),
    /**
     * 提币
     */
    extract(3),
    /**
     * 转币
     */
    turn(4),
    /**
     * 系统
     */
    system(5),
    /**
     * 其他
     */
    other(6),
    /**
     * 下单
     */
    createOrder(8),
    /**
     * 下单
     */
    createOrderRollBack(9),
    /**
     * 手续费
     */
    fee(7),
    ;

    private int optSource;

    AssetsCoinOptSourceEnum(int optSource) {
        this.optSource = optSource;
    }

    public int getOptSource() {
        return optSource;
    }

    public static AssetsCoinOptSourceEnum getOptSourceEnumBySource(int optSource) {
        for (AssetsCoinOptSourceEnum enums : AssetsCoinOptSourceEnum.values())
            if (enums.getOptSource() == optSource)
                return enums;
        return null;
    }
}
