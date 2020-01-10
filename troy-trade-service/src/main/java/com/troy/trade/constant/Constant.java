package com.troy.trade.constant;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * 常量定义
 *
 * @author Han
 */
public class Constant {
    public static final String BIND_ACCOUNT_NAME_PREFIX = "bind-";
    public static final String UN_BIND_ACCOUNT_NAME_MIDDLE = "-";
    public static final String REGEX_ACCOUNT_NAME = "^[0-9a-z]{8,32}$";
    public static final String QUERY_CHARGE_COIN_STATUS_URL = "https://www.blockchain.com/btc/address/";
    public static final String QUERY_CHARGE_COIN_STATUS_URL_EOS = "https://eospark.com/MainNet/account/1tokentomoon";
    public static final String EXCH_COIN_NAME_EOS = "EOS";
    public static final String EOS_CHARGE_COIN_ADDR_NAME = "troytomoon";

    public static final Set<String> TASKSET = new HashSet();

    /**
     * 记录在运行中的调度任务Future
     */
    public static final Map<String, ScheduledFuture<?>> TASK_FUTURES = new ConcurrentHashMap<String, ScheduledFuture<?>>();

    /**
     * 单次撤单的最大条数
     */
    public static final Integer SINGLE_CANCEL_MAX_COUNT_DEFAULT = 200;

    /**
     * 状态 -- 未启用
     */
    public static final Integer STATUS_OFF = 0;

    /**
     * 状态 -- 启用
     */
    public static final Integer STATUS_ON = 1;

    /**
     * 订单来源--手动
     */
    public static final int SOURCE_MANUAL = 0;

    /**
     * 订单来源--机器人自动
     */
    public static final int SOURCE_ROBOT_AUTO = 1;

    /**
     * 订单来源--排单机器人自动
     */
    public static final int SOURCE_ROBOT_SORT_AUTO = 2;

    /**
     * 币安排单请求限速，查询类
     */
    public static final String BINANCE_REQ_SORT_ROBOT_LIMIT_QUERY = "binance_req_limit-sort_robot_query_";

    /**
     * 币安请求限速，查询类
     */
    public static final String BINANCE_REQ_LIMIT_QUERY = "binance_req_limit-query_";

    /**
     * 批量新增时的最大个数--500
     */
    public static final int INSERT_BATCH_SIZE = 500;

    /**
     * 批量修改时的最大个数--500
     */
    public static final int UPDATE_BATCH_SIZE = 500;

    /**
     * 火币 币币账户标识名称
     */
    public static final String HUOBI_SPOT_ACCT_NAME = "spot";

    /**
     * 交易对间隔
     */
    public static final String SYMBOL_SEPARATOR = "/";

    /**
     * coinName币种名称usdt
     */
    public static final String SYMBOL_USDT = "usdt";

    /**
     * coinName币种名称usd
     */
    public static final String SYMBOL_USD = "usd";

    /**
     * coinName币种名称btc
     */
    public static final String SYMBOL_BTC = "btc";

    /**
     * coinName币种名称xbt
     */
    public static final String SYMBOL_XBT = "xbt";

    /**
     * coinName币种名称eth
     */
    public static final String SYMBOL_ETH = "eth";

    /**
     * coinName币种名称cny
     */
    public static final String SYMBOL_CNY = "cny";

    /**
     * 交易对名称usdt_cny
     */
    public static final String SYMBOL_USDT_CNY = Constant.SYMBOL_USDT+"/cny";



    /**
     * 币种状态，不可充提币
     */
    public static final Integer COINSTSTUS_DEPOSIT_WITHDRAW_CANNOT = 0;

    /**
     * 币种状态，可提币可充币
     */
    public static final Integer COINSTSTUS_DEPOSIT_WITHDRAW_CAN = 1;

    /**
     * 币种状态，只可提币
     */
    public static final Integer COINSTSTUS_WITHDRAW_CAN = 2;

    /**
     * 币种状态，只可充币
     */
    public static final Integer COINSTSTUS_DEPOSIT_CAN = 3;


    /**
     * 价格信息同步redis key 前缀
     */
    public static final String PRICE_REDIS_KEY_PREFIX = "price:";

    /**
     * 信息同步币种转其他币种价格 redis key
     */
    public static final String PRICE_COIN_TURN_REDIS_KEY = PRICE_REDIS_KEY_PREFIX + "tickerPrice:{exchCode}:";

    /**
     * 信息同步币种转其他币种价格incr redis key
     */
    public static final String PRICE_COIN_TURN_INCR_REDIS_KEY = PRICE_REDIS_KEY_PREFIX + "incr:{exchCode}:";

    /**
     * 账户清算超时时间
     */
    public static final Long PRICE_COIN_TURN_TIME_OUT = 5L;

    /**
     * 价格信息查询地，从缓存中取
     */
    public static final Integer PRICE_VALUES_OF_REDIS = 1;

    /**
     * 价格信息查询地，调交易所的tickerPrice接口查
     */
    public static final Integer PRICE_VALUES_OF_EXCHANGE = 2;


    /********* 平台账户充提币 相关 --- 开始 ************************************************/

//    1-申请中、2-已完成、3-已取消、4-失败
    /**
     * 账户充提记录状态 - 申请中
     */
    public static final Integer HARK_WITHDRAWAL_STATUS_ING = 1;

    /**
     * 账户充提记录状态 - 已完成
     */
    public static final Integer HARK_WITHDRAWAL_STATUS_DEAL = 2;

    /**
     * 账户充提记录状态 - 已取消
     */
    public static final Integer HARK_WITHDRAWAL_STATUS_CANCEL = 3;

    /**
     * 账户充提记录状态 - 失败
     */
    public static final Integer HARK_WITHDRAWAL_STATUS_FAIL = 4;

    /**
     * 第三方账户充提币记录type -- 充值
     */
    public static final Integer DEPOSIT_WITHDRAWAL_TYPE_DEPOSIT = 1;

    /**
     * 第三方账户充提币记录type -- 提现
     */
    public static final Integer DEPOSIT_WITHDRAWAL_TYPE_WITHDRAWAL = 2;

    /********* 平台账户充提币 相关 --- 结束 ************************************************/

    /**
     * 缓存中的用户现货挂单限制表
     */
    public static final String SPOT_PENDING_LIMIT_TABLE = "spot:pending:limit";

    /**
     * 缓存中的用户现货挂单限制KEY
     */
    private static final String SPOT_PENDING_LIMIT_KEY = "{userId}:{exchCode}";

    /**
     * 缓存中的交易所账户分配KEY
     */
    public static final String EXCHANGE_ACCOUNT_DISTRIBUTE_KEY = "exchange:account:distribute:{exchCode}";

    /**
     * troy 交易所code
     */
    public static final String EXCHANGE_CODE_TROY = "troy";

    /**
     * 获取缓存中的用户现货挂单限制KEY
     * @param userId
     * @param exchCode
     * @return
     */
    public static String getSpotPendingLimitKey(Long userId, String exchCode){
        return SPOT_PENDING_LIMIT_KEY.replace("{userId}", userId.toString()).replace("{exchCode}", exchCode);
    }

    /**
     * 交易所合约币对信息KEY
     */
    public static final String EXCHANGE_FUTURES_SYMBOL_REDIS_KEY = "exchange:futures:symbol:%s";
}
