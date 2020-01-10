package com.troy.trade.task.executor.schedule;

import com.alibaba.fastjson.JSONObject;
import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.trade.api.model.constant.account.AccountBindStatus;
import com.troy.trade.api.model.constant.account.ExchangeAccountStatus;
import com.troy.trade.constant.Constant;
import com.troy.trade.model.domain.account.AccountBindModel;
import com.troy.trade.model.domain.exchange.ExchangeAccountModel;
import com.troy.trade.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * 数据同步处理相关业务方法
 *
 * @auth
 */
@Slf4j
@Component
public class SyncOrderInfoScheduledUtil {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private IExchangeAccountService exchangeAccountService;

    @Autowired
    private IAccountBindService accountBindService;

    @Autowired
    private ISpotTransPendingService spotTransPendingService;

    @Autowired
    private ISpotDayBtcService spotDayBtcService;
    @Autowired
    private IAccountOverAssetsService accountOverAssetsService;

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;


    /**
     * 超额资产初始化
     */
    public void synOverAssets() {
        accountOverAssetsService.synOverAssets();
    }
    /**
     * 超额资产增量更新
     */
    public void synUpdateOverAssets() {
        accountOverAssetsService.synUpdateOverAssets();
    }

    /**
     * 初始化调度
     */
    public void initScheduler() {
        log.info("初始化runner开始");
        initSynOrderStatus();

    }
    /**
     * 新增交易所账户时增加调度任务
     */
    public void initSynOrderStatus() {
        /**
         * 做调度初始化：初始化范围交易所和账户均为启用状态
         */
        threadPoolTaskScheduler.setPoolSize(100);
        List<ExchangeAccountModel> exchangeAccountModelList = getExchangeAccountModels(ExchangeAccountStatus.YES.getCode(),null);
        List<AccountBindModel> accountBindModelList = getAccountBindModels(AccountBindStatus.BIND.getCode(),null);

        // 交易所账户
        if (exchangeAccountModelList!=null && exchangeAccountModelList.size()>0){
            exchangeAccountModelList.stream().forEach(exchangeAccount -> {
                addSynExchangeAccountOrder(exchangeAccount);
            });
        }

        //绑定账号
        if (accountBindModelList!=null && accountBindModelList.size()>0){
            accountBindModelList.stream().forEach(accountBindModel -> {
                addSynAccountBindOrder(accountBindModel);
            });
        }
    }

    /**
     * 添加 新增绑定账号的定时任务
     * @param accountBindModel
     */
    public void addSynAccountBindOrder(AccountBindModel accountBindModel){
        log.info("初始化同步三方任务，绑定账户：{}", accountBindModel.getAccountBindId());
        threadPoolTaskScheduler.setThreadNamePrefix("Schedule-Task-accountBindModel-");
        ExchAcctBindTaskThread exchAcctTaskThread = new ExchAcctBindTaskThread();
        exchAcctTaskThread.setAccountModel(accountBindModel);
        ScheduledFuture scheduledFuture = null;
        if (accountBindModel.getExchCode().equals(ExchangeCode.BINANCE.code())){
            scheduledFuture = threadPoolTaskScheduler.scheduleWithFixedDelay(exchAcctTaskThread, 2000L);
        }else {
            scheduledFuture = threadPoolTaskScheduler.scheduleWithFixedDelay(exchAcctTaskThread, 500L);
        }
        Constant.TASK_FUTURES.put(accountBindModel.getAccountBindId() + "", scheduledFuture);
        Constant.TASKSET.add(accountBindModel.getAccountBindId() + "");
    }

    /**
     * 添加 新增交易所账户的定时任务
     * @param exchangeAccount
     */
    public void addSynExchangeAccountOrder(ExchangeAccountModel exchangeAccount){
        log.info("初始化同步三方任务，交易所账户：{}", exchangeAccount.getExchAcctId());
        threadPoolTaskScheduler.setThreadNamePrefix("Schedule-Task-exchangeAccount-");
        ExchAcctTaskThread exchAcctTaskThread = new ExchAcctTaskThread();
        exchAcctTaskThread.setAccountModel(exchangeAccount);
        ScheduledFuture scheduledFuture = null;
        if (exchangeAccount.getExchCode().equals(ExchangeCode.BINANCE.code())){
            scheduledFuture = threadPoolTaskScheduler.scheduleWithFixedDelay(exchAcctTaskThread, 2000L);
        }else {
            scheduledFuture = threadPoolTaskScheduler.scheduleWithFixedDelay(exchAcctTaskThread, 500L);
        }

        Constant.TASK_FUTURES.put(exchangeAccount.getExchAcctId() + "", scheduledFuture);
        Constant.TASKSET.add(exchangeAccount.getExchAcctId() + "");
    }

    /**
     * 停止调度
     * @param exchAcctId
     */
    public void stopScheduled(String exchAcctId){

        if(Constant.TASKSET.contains(exchAcctId)){
            Constant.TASKSET.remove(exchAcctId);
        }

        if(Constant.TASK_FUTURES.containsKey(exchAcctId)){
            ScheduledFuture scheduledFuture = Constant.TASK_FUTURES.get(exchAcctId);
            scheduledFuture.cancel(true);
            Constant.TASK_FUTURES.remove(exchAcctId);
            log.debug("当前停止的账号ID="+exchAcctId+"。调度任务停止后，当前调度任务有"+ JSONObject.toJSONString(Constant.TASK_FUTURES));
        }
    }

    /**
     * 同步第三方手续费
     */
    public void syncThirdDelFeeJob() {
        taskService.syncThirdDelFee();
    }
    /**
     * 同步订单详情数据
     */
    public void syncOrderDetails() {
        List<ExchangeAccountModel> exchangeAccountModelList = getExchangeAccountModels(ExchangeAccountStatus.YES.getCode(),ExchangeCode.BINANCE.code());
        List<AccountBindModel> accountBindModelList = getAccountBindModels(AccountBindStatus.BIND.getCode(),ExchangeCode.BINANCE.code());

        for (ExchangeAccountModel exchangeAccountModel : exchangeAccountModelList) {
            taskService.syncExchangeAccountByExchCode(exchangeAccountModel,ExchangeCode.BINANCE.code());
        }
        for (AccountBindModel accountBindModel : accountBindModelList) {
            taskService.syncAccountBindByExchCode(accountBindModel,ExchangeCode.BINANCE.code());
        }
    }

    /**
     * 查询绑定账户列表 状态（0-禁用，1-启用）
     *
     * @return
     */
    private List<AccountBindModel> getAccountBindModels(Integer status, String exchCode) {
        AccountBindModel queryBindAccount = new AccountBindModel();
        queryBindAccount.setStatus(status);
        if (StringUtils.isNotEmpty(exchCode)){
            queryBindAccount.setExchCode(exchCode);
        }
        return accountBindService.queryForList(queryBindAccount);
    }

    /**
     * 查询troy账户列表 状态（0-禁用，1-启用）
     *
     * @return
     */
    private List<ExchangeAccountModel> getExchangeAccountModels(Integer status, String exchCode) {
        ExchangeAccountModel queryAccount = new ExchangeAccountModel();
        queryAccount.setStatus(status);
        if (StringUtils.isNotEmpty(exchCode)){
            queryAccount.setExchCode(exchCode);
        }
        return exchangeAccountService.queryForList(queryAccount);
    }

    public void syncTransPendToHistory() {
        spotTransPendingService.syncTransPendToHistory();
    }

    public void calateUserFeeLevel() {
        spotDayBtcService.calateUserFeeLevel();
    }

    public void calateUserBtcByDay() {
        spotDayBtcService.calateUserBtcByDay();
    }
}
