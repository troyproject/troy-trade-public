package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.util.SyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时BTW提币信息查询确认
 *
 * @author zcj
 */
@Slf4j
@JobHandler(value="walletExtractCoinQuery")
@Component
public class WalletExtractCoinQueryJobHandler extends IJobHandler {

    @Autowired
    private SyncScheduledUtil syncScheduledUtil;

    // cron = "30 0/1 * * * ?
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncScheduledUtil.walletExtractCoinQueryTask();
        return SUCCESS;
    }
}
