package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.util.SyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时BTW充币信息查询确认
 *
 * @author zcj
 */
@Slf4j
@JobHandler(value="walletRechargeCoinConfirm")
@Component
public class WalletRechargeCoinConfirmJobHandler extends IJobHandler {

    @Autowired
    private SyncScheduledUtil syncScheduledUtil;

    // cron = "0 0/1 * * * ?
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncScheduledUtil.walletRechargeCoinConfirmTask();
        return SUCCESS;
    }
}
