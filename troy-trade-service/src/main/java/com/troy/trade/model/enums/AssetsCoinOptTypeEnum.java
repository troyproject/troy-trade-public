package com.troy.trade.model.enums;

import com.troy.trade.model.dto.in.AssetsCoinOpt;

/**
 * 账户币种操作类型
 *
 * @author zhangchengjie
 * @date 2019/08/19
 * @see AssetsCoinOpt
 */

public enum AssetsCoinOptTypeEnum {

    /**
     * 增加
     */
    add(1),
    /**
     * 减少
     */
    reduce(2),
    /**
     * 冻结
     */
    frozen(3),
    /**
     * 解冻
     */
    unfrozen(4),
    /**
     * 回滚冻结
     */
    rollback(5),
    /**
     * 解冻且回滚
     */
    unfrozenAndRollback(6),
    ;

    private int optType;

    AssetsCoinOptTypeEnum(int optType) {
        this.optType = optType;
    }

    public int getOptType() {
        return optType;
    }

    public static AssetsCoinOptTypeEnum getOptTypeEnumByType(int optType) {
        for (AssetsCoinOptTypeEnum enums : AssetsCoinOptTypeEnum.values())
            if (enums.getOptType() == optType)
                return enums;
        return null;
    }
}
