package com.troy.trade.configurator;

/**
 * @author zhangchengjie
 * @date 2019/08/23
 */
public interface TableShardConstant {

    interface AccountCoin {
        String TABLE_NAME = "account_coin_part";
        String SHARD_TYPE = "mod_account_id";
        String SHARD_BY = "shard_account_id";
    }

}
