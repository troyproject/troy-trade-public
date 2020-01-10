package com.troy.trade.constant;

public class ScheduledConstant {


    /**
     * 数据同步类型 -- 系统自动
     */
    public static final int SYNC_SAVE_TYPE_SYS = 1;

    /**
     * 数据同步类型 -- 用户手动
     */
    public static final int SYNC_SAVE_TYPE_MANUAL = 2;

    /**
     * 状态 停用
     */
    public final static Integer SYMBOL_STATUS_OFF = 0;

    /**
     * 状态 启用
     */
    public final static Integer SYMBOL_STATUS_ON = 1;

    /********* 数据同步相关 -- 开始 *************************/

    /**
     * 数据同步相关前缀
     */
    public static final String SYNC_REDIS_KEY_PREFIX = "sync:";

    /**
     * 缓存中保存交易所数据前缀
     */
    public static final String EXCHANGE_DATA_REDIS_KEY_PREFIX = "exchange:";

    /**
     * 缓存中保存同步数据前缀
     */
    public static final String DATA_REDIS_KEY_PREFIX = "data:";

    /********* 交易对同步相关 -- 开始 *************************/

    /**
     * 交易对同步相关前缀
     */
    public static final String SYNC_SYMBOL_REDIS_KEY_PREFIX = SYNC_REDIS_KEY_PREFIX+"symbol:";

    /**
     * 交易对同步中相关标记
     */
    public static final String SYNC_SYMBOL_INCR_REDIS_KEY = SYNC_SYMBOL_REDIS_KEY_PREFIX+"incr";

    /**
     * 交易对同步相关前缀
     */
    public static final String SYNC_SYMBOL_EXCHCODE_MAP_REDIS_KEY = SYNC_SYMBOL_REDIS_KEY_PREFIX+"exchCode";

    /**
     * 交易对同步超时时间
     */
    public static final Long SYNC_SYMBOL_MAP_TIME_OUT = 5L;

    /********* 交易对同步相关 -- 结束 *************************/

    /********* 全量ticker信息同步相关 -- 开始 *********************************/

    public static final String SYNC_ALL_TICKER_REDIS_KEY_PREFIX = SYNC_REDIS_KEY_PREFIX+"allTicker:";

    /**
     * 所有ticker信息列表同步中标记 redis key
     */
    public static final String SYNC_ALL_TICKER_INCR_REDIS_KEY = SYNC_ALL_TICKER_REDIS_KEY_PREFIX+"incr";

    /**
     * 交易所全量ticker信息同步相关前缀
     */
    public static final String SYNC_ALL_TICKER_EXCHCODE_MAP_REDIS_KEY = SYNC_ALL_TICKER_REDIS_KEY_PREFIX+"exchCode";

    /**
     * 账户清算超时时间
     */
    public static final Long SYNC_ALL_TICKER_TIME_OUT = 5L;

    /**
     * 所有ticker信息列表 map key-symbol、value-ticker
     */
    public static final String EXCHANGE_DATA_ALL_TICKER_REDIS_KEY = EXCHANGE_DATA_REDIS_KEY_PREFIX+"ticker:{exchCode}:allTicker";

    /**
     * 所有ticker信息列表当前价格转CNY map
     */
    public static final String EXCH_TICKER_LAST_TURN_CNY_MAP_REDIS_KEY = EXCHANGE_DATA_REDIS_KEY_PREFIX+"ticker:{exchCode}:lastTurnCny";

    /**
     * 所有ticker信息列表当前价格转USDT map
     */
    public static final String EXCH_TICKER_LAST_TURN_USDT_MAP_REDIS_KEY = EXCHANGE_DATA_REDIS_KEY_PREFIX+"ticker:{exchCode}:lastTurnUsdt";

    /********* 全量ticker信息同步相关 -- 结束 *********************************/

//    /********* USDT转人民币信息相关 -- 开始 ***********************************/
//    /**
//     * 交易系统 usdt转cny 相关redis前缀
//     */
//    public static final String TURN_USDT_CNY_REDIS_KEY = EXCHANGE_DATA_REDIS_KEY_PREFIX+"turn:usdt_cny:";
//
//    /**
//     * 交易系统 usdt转cny 相关 incr
//     */
//    public static final String TURN_USDT_CNY_INCR_REDIS_KEY = TURN_USDT_CNY_REDIS_KEY+"incr";
//
//    /**
//     * 交易系统 usdt转cny 相关 price
//     */
//    public static final String TURN_USDT_CNY_PRICE_REDIS_KEY = TURN_USDT_CNY_REDIS_KEY+"price";
//
//    /**
//     * 账户清算超时时间
//     */
//    public static final Long TURN_USDT_CNY_TIME_OUT = 60L;
//
//
//    /********* USDT转人民币信息相关 -- 结束 ***********************************/


    /*************** 大额转移数据同步 --  常量 开始 ******************************************/
    /**
     * 大额转移数据同步 -- 币种每最后一分钟数据同步 redis key 前缀
     *
     */
    public static final String BLOCKCHAINLARGETRANSFER_REDIS_KEY_PREFIX = SYNC_REDIS_KEY_PREFIX+"blockchainLargetransfer:";
    /**
     * 大额转移数据同步 -- 币种每最后一分钟数据同步 incr redis key 前缀
     */
    public static final String BLOCKCHAINLARGETRANSFER_INCR_REDIS_KEY = BLOCKCHAINLARGETRANSFER_REDIS_KEY_PREFIX + "incr";

    /**
     * 账户清算超时时间
     */
    public static final Long BLOCKCHAINLARGETRANSFER_TICKER_TIME_OUT = 5L;

    /*************** 大额转移数据同步 -- 常量 结束 ******************************************/

    /*************** 市场异动信息同步 -- 开始 ********************************/

    /**
     * 异动数据列表 缓存 redis key
     */
    public static final String EXCHANGE_ABNORMALCHANGES_LIST_REDIS_KEY = DATA_REDIS_KEY_PREFIX+"abnormalChanges:List";

    /********* 市场异动信息同步 -- 结束 *************************/


    /*************** 链上数据同步处理 常量 开始 ******************************************/

    public static String BITFINEX_POSITION_RATIO = "data:bitfinex_position_ratio:{type}";

    public static String BLOCKCHAINCHART_TYPE_TRANSACTIONS = "transactions";

    public static String BLOCKCHAINCHART_TYPE_SENTINUSD = "sentinusd";

    public static String BLOCKCHAINCHART_TYPE_TRANSACTIONVALUE = "transactionvalue";

    public static String BLOCKCHAINCHART_TYPE_ACTIVEADDRESSES = "activeaddresses";

    public static String BLOCKCHAINCHART_REDIS_KEY_PREFIX = "data:blockchainchart:";

    public static String BLOCKCHAINCHART_TRANSACTIONS_REDIS_KEY = BLOCKCHAINCHART_REDIS_KEY_PREFIX+BLOCKCHAINCHART_TYPE_TRANSACTIONS;

    public static String BLOCKCHAINCHART_SENTINUSD_REDIS_KEY = BLOCKCHAINCHART_REDIS_KEY_PREFIX+BLOCKCHAINCHART_TYPE_SENTINUSD;

    public static String BLOCKCHAINCHART_TRANSACTIONVALUE_REDIS_KEY = BLOCKCHAINCHART_REDIS_KEY_PREFIX+BLOCKCHAINCHART_TYPE_TRANSACTIONVALUE;

    public static String BLOCKCHAINCHART_ACTIVEADDRESSES_REDIS_KEY = BLOCKCHAINCHART_REDIS_KEY_PREFIX+BLOCKCHAINCHART_TYPE_ACTIVEADDRESSES;

    public static final String TODAMOON_TYPE_BITFINEX_POSITION_RATIO = "bitfinexpositionratio";//bitifnex持仓比例


    /**
     * 折线类型 -- 分钟
     */
    public static final String TODAMOON_TYPE_BITFINEX_TYPE_MINUTE = "minute";

    /**
     * 折线类型 -- 小时
     */
    public static final String TODAMOON_TYPE_BITFINEX_TYPE_HOUR = "hour";

    /**
     * 折线类型 -- 日
     */
    public static final String TODAMOON_TYPE_BITFINEX_TYPE_DAY = "day";

    /**
     * 永续合约费率
     */
    public static final String TODAMOON_TYPE_BITMEX_CONTRACTRATE = "contractrate";


    /*************** 交易所日成交量 常量 结束 ******************************************/

    /*************** 平台账户清算数据同步  开始 **********************************/
    /**
     * 账户信息同步redis key 前缀
     * sync:exchAcctClear:
     */
    public static final String EXCH_ACCT_CLEAR_REDIS_KEY_PREFIX = SYNC_REDIS_KEY_PREFIX+"exchAcctClear:";

    /**
     * 账户信息同步中标记redis key
     * sync:exchAcctClear:{exchAcctId}:incr
     */
    public static final String EXCH_ACCT_CLEAR_INCR_REDIS_KEY = EXCH_ACCT_CLEAR_REDIS_KEY_PREFIX+"{exchAcctId}:incr";

    /**
     * 账户信息同步redis key 前缀
     * sync:exchAcctClear:{clearTime}:exchAcctId
     */
    public static final String EXCH_ACCT_CLEAR_MAP_REDIS_KEY = EXCH_ACCT_CLEAR_REDIS_KEY_PREFIX+"{clearTime}:exchAcctId";

    /**
     * 账户清算超时时间
     */
    public static final Long EXCH_CLEAR_TIME_OUT = 5L;

    /**
     * 清算全部交易所账户
     */
    public static final String EXCH_ACCT_CLEAR_ALL = "all";


    /*************** 平台账户清算数据同步  结束 **********************************/

    /**
     * 同步合约信息
     */
    public static final String INSTRUMENTS_ALL_PREFIX = EXCHANGE_DATA_REDIS_KEY_PREFIX + "instruments:%s";

    /**
     * 交易所合约ticker
     */
    public static final String EXCHANGE_FUTURES_ALL_TICKER_REDIS_KEY = EXCHANGE_DATA_REDIS_KEY_PREFIX + "ticker:%s:allTicker";

    /**
     * 交易所合约k线
     */
    public static final String EXCHANGE_FUTURES_KLINE_REDIS_KEY = EXCHANGE_DATA_REDIS_KEY_PREFIX + "kline:%s";

}
