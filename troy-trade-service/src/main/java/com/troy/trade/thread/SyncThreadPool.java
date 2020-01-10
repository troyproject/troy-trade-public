package com.troy.trade.thread;

import java.util.concurrent.*;

public class SyncThreadPool {

    /**
     * 交易对列表同步
     */
    private static final ThreadPoolExecutor EXECUTOR_SYMBOL_SYNC = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 30, 10L,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10000), r -> {
        Thread t = new Thread(r);
        return t;
    }, new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 全部ticker信息同步
     */
    private static final ThreadPoolExecutor EXECUTOR_ALLTICKERS_SYNC = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 30, 10L,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10000), r -> {
        Thread t = new Thread(r);
        return t;
    }, new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 平台账户清算
     */
    private static final ThreadPoolExecutor EXECUTOR_EXCH_ACCT_CLEARING = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 10, 10L,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10000), new ThreadFactory() {

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            return t;
        }
    }, new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 合约ticker
     */
    private static final ThreadPoolExecutor EXECUTOR_EXCH_FUTURES_TICKER_CLEARING = new ThreadPoolExecutor(10, 10, 10L,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

    static {
        EXECUTOR_SYMBOL_SYNC.prestartAllCoreThreads();
        EXECUTOR_ALLTICKERS_SYNC.prestartAllCoreThreads();
        EXECUTOR_EXCH_ACCT_CLEARING.prestartAllCoreThreads();
        EXECUTOR_EXCH_FUTURES_TICKER_CLEARING.prestartAllCoreThreads();
    }

    public static void executeSymbolSync(SymbolSyncExecute exchAcctClearExecute) throws Throwable {
        EXECUTOR_SYMBOL_SYNC.submit(exchAcctClearExecute);
    }

    public static void executeAllTickersSync(AllTickersSyncExecute allTickersSyncExecute) throws Throwable {
        EXECUTOR_ALLTICKERS_SYNC.submit(allTickersSyncExecute);
    }

    public static void executeExchAcctClearing(ExchAcctClearExecute exchAcctClearExecute) throws Throwable {
        EXECUTOR_EXCH_ACCT_CLEARING.submit(exchAcctClearExecute);
    }

    public static void executeFuturesTicker(Callable callable) {
        EXECUTOR_EXCH_FUTURES_TICKER_CLEARING.submit(callable);
    }
}
