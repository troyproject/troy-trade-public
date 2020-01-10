package com.troy.trade.task.executor.schedule;


import com.troy.commons.utils.ApplicationContextUtil;
import com.troy.trade.model.domain.exchange.ExchangeAccountModel;
import com.troy.trade.service.ITaskService;
import com.troy.trade.util.IPV4Util;
import com.troy.trade.util.JobServiceImpl;

/**
 * 账户交易记录同步线程
 * @author dp
 */
public class ExchAcctTaskThread extends Thread {
    private ExchangeAccountModel accountModel;

    @Override
    public void run(){
        // 判断是否是集群中IP最小的服务器
        JobServiceImpl jobService = ApplicationContextUtil.getBean(JobServiceImpl.class);
        if (!IPV4Util.ipCompare(jobService.defaultServiceUrl())) {
            return;
        }
        ITaskService taskService = ApplicationContextUtil.getBean(ITaskService.class);
        taskService.syncExchangeAccountThirdOrderStatus(accountModel);
    }

    public ExchangeAccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(ExchangeAccountModel accountModel) {
        this.accountModel = accountModel;
    }
}
