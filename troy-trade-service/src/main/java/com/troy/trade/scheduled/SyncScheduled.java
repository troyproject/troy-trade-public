//package com.troy.trade.scheduled;
//
//import com.troy.commons.utils.DateUtils;
//import com.troy.redis.RedisUtil;
//import com.troy.trade.constant.Constant;
//import com.troy.trade.constant.ScheduledConstant;
//import com.troy.trade.model.dto.in.SpotTransLimitReqDto;
//import com.troy.trade.model.dto.out.SpotTransLimitResDto;
//import com.troy.trade.service.ISpotTransPendingService;
//import com.troy.trade.service.data.IUsdtPremiumService;
//import com.troy.trade.util.DataSyncScheduledUtil;
//import com.troy.trade.util.SyncOrderInfoScheduledUtil;
//import com.troy.trade.util.SyncScheduledUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * 调度
// *
// * @author
// */
//@Slf4j
//@Component
//public class SyncScheduled {
//
//    @Autowired
//    private SyncScheduledUtil syncScheduledUtil;
//
//    @Autowired
//    private DataSyncScheduledUtil dataSyncScheduledUtil;
//
//    @Autowired
//    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;
//
//    @Autowired
//    private IUsdtPremiumService usdtPremiumService;
//
//    @Autowired
//    private ISpotTransPendingService spotTransPendingService;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    /**
//     * 每10分钟初始化一次用户的挂单数
//     */
//    @Scheduled(fixedDelay = 10 * 60 * 1000)
//    public void initAllUserPendingLimit() {
//        List<SpotTransLimitResDto> spotTransLimitResDtos = spotTransPendingService.querySpotTransLimit(new SpotTransLimitReqDto());
//        if (CollectionUtils.isEmpty(spotTransLimitResDtos)) {
//            redisUtil.hDelAll(Constant.SPOT_PENDING_LIMIT_TABLE);
//            return;
//        } else {
//            redisUtil.hDelAll(Constant.SPOT_PENDING_LIMIT_TABLE);
//            spotTransLimitResDtos.stream().forEach(spotTransLimitResDto -> redisUtil.hset(Constant.SPOT_PENDING_LIMIT_TABLE, Constant.getSpotPendingLimitKey(spotTransLimitResDto.getUserId(), spotTransLimitResDto.getExchCode()), spotTransLimitResDto.getCountNum() + ""));
//        }
//    }
//
//    /**
//     * 全部ticker信息同步
//     */
//    @Scheduled(fixedDelay = 5000)
//    public void syncFullTickers() {
//        try {
//            syncScheduledUtil.syncAllTIckers(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
//        } catch (Throwable throwable) {
//            log.error("调用binance查询所有交易对ticker数据异常，异常信息：", throwable);
//        }
//    }
//
//    /**
//     * 大额转移数据同步
//     */
//    @Scheduled(cron = "0 0/30 * * * ?")
//    public void blockChainLargeTransfer() {
//        try {
//            dataSyncScheduledUtil.syncBlockchainLargetransfer(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
//        } catch (Throwable throwable) {
//            log.error("同步大额资产转移数据异常，异常信息：", throwable);
//        }
//    }
//
//    /**
//     * 交易所异动数据同步处理
//     */
//    @Scheduled(fixedDelay = 300000)
//    public void syncAbnormalChanges() {
//        try {
//            dataSyncScheduledUtil.syncAbnormalChanges();
//        } catch (Throwable throwable) {
//            log.error("调用交易所查询异动数据：异常，异常信息：", throwable);
//        }
//    }
//
//    /**
//     * usdt与USD溢价数据
//     */
//    @Scheduled(cron = "59 59 23 * * ?")
//    public void syncUsdtPremium() {
//        try {
//            usdtPremiumService.syncUsdtPremium();
//        } catch (Throwable throwable) {
//            log.error("同步usdt与USD溢价数据：异常，异常信息：", throwable);
//        }
//    }
//
//    /************************** 从测试库同步数据到生产处理 -- 开始 **************/
//
//    /**
//     * 从测试库同步数据到生产处理
//     */
//    @Scheduled(fixedDelay = 5 * 60 * 1000)
//    public void troySyncDataFromTest() {
//        log.info("从测试库同步数据到生产处理---------------当前时间" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME));
//        try {
//            dataSyncScheduledUtil.troySyncDataFromTest();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("从测试库同步数据到生产处理异常，异常信息：", throwable);
//        }
//    }
//    /************************** 从测试库同步数据到生产处理 -- 结束 **************/
//
//    /************************** 交易所账户自动清算处理 -- 开始 **************/
//    /**
//     * 交易所账户清算报表
//     */
//    @Scheduled(cron = "0 0 0/1 * * ?")
//    public void clearing() {
//        log.info("每小时自动清算开始---------------当前时间" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME));
//        try {
//            dataSyncScheduledUtil.dealExchAcctClear(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//
//    /************************** 交易所账户自动清算处理 -- 结束 **************/
//
//    /************************** 超额资产转出提现状态同步处理 -- 开始 **************/
//    /**
//     * 超额资产转出提现状态同步
//     */
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void withdraw() {
//        log.info("超额资产转出提现状态同步开始---------------当前时间" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME));
//        try {
//            dataSyncScheduledUtil.syncWithdrawStatus(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//    /************************** 超额资产转出提现状态同步处理 -- 结束 **************/
//
//    /**
//     * 定时BTW充币信息查询确认
//     */
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void walletRechargeCoinConfirmTask() {
//        log.info("定时充币信息查询确认任务开始执行");
//        try {
//            syncScheduledUtil.walletRechargeCoinConfirmTask();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("定时充币信息查询确认异常", throwable);
//        }
//    }
//
//    /**
//     * 定时BTW提币信息查询确认
//     */
//    @Scheduled(cron = "30 0/1 * * * ?")
//    public void walletExtractCoinQueryTask() {
//        log.info("定时提币信息查询任务开始执行");
//        try {
//            syncScheduledUtil.walletExtractCoinQueryTask();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("定时提币币信息查询异常", throwable);
//        }
//    }
//
//    /**
//     * 定时处理用户转币
//     */
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void handleTransCoinTask() {
//        log.info("定时转币信息查询任务开始执行");
//        try {
//            syncScheduledUtil.handleTransCoinTask();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("定时转币信息查询异常", throwable);
//        }
//    }
//
//    /**
//     * 定时任务-归集账单查询
//     */
//    @Scheduled(cron = "0 0/10 * * * ?")
//    public void queryBillListTask() {
//        log.info("定时任务-归集账单查询任务开始执行");
//        try {
//            syncScheduledUtil.queryBillListTask();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("定时任务-归集账单查询异常", throwable);
//        }
//    }
//
//
//    /**
//     * 同步第三方手续费 币安 ok
//     *
//     * @throws Exception
//     */
//    @Scheduled(fixedDelay = 5000)
//    void syncThirdDelFeeJob() {
//        log.info("同步第三方手续费任务开始执行");
//        try {
//              syncOrderInfoScheduledUtil.syncThirdDelFeeJob();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("同步第三方手续费异常", throwable);
//        }
//    }
//
//    /**
//     * 同步订单详情 币安 ok
//     *
//     * @throws Exception
//     */
//    @Scheduled(fixedDelay = 500000)
//    void syncOrderDetails() {
//        log.info(" 同步订单详情开始执行");
//        try {
//            syncOrderInfoScheduledUtil.syncOrderDetails();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error(" 同步订单详情异常", throwable);
//        }
//    }
//
//    /**
//     * 将挂单表数据同步到历史表
//     *
//     * @throws Exception
//     */
//    @Scheduled(fixedDelay = 5000)
//    void syncTransPendToHistory() {
//        log.info("将挂单表数据同步到历史表");
//        try {
//            syncOrderInfoScheduledUtil.syncTransPendToHistory();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("将挂单表数据同步到历史表异常", throwable);
//        }
//    }
//
//    /**
//     * 计算用户每天的交易量
//     *
//     * @throws Exception
//     */
//    //@Scheduled(fixedDelay = 5000)
//    @Scheduled(cron = "0 0 11 * * ?")
//    void calateUserBtcByDay() {
//        log.info("计算用户手续费等级");
//        try {
//            syncOrderInfoScheduledUtil.calateUserBtcByDay();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("计算用户手续费等级异常", throwable);
//        }
//    }
//    /**
//     * 计算用户手续费等级
//     *
//     * @throws Exception
//     */
//    //@Scheduled(fixedDelay = 5000)
//    @Scheduled(cron = "0 0 8 * * ?")
//    void calateUserFeeLevel() {
//        log.info("计算用户手续费等级");
//        try {
//            syncOrderInfoScheduledUtil.calateUserFeeLevel();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            log.error("计算用户手续费等级异常", throwable);
//        }
//    }
//}
