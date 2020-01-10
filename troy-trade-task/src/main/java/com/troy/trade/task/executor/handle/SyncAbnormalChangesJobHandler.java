package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.util.DataSyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 交易所异动数据同步处理
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="syncAbnormalChanges")
@Component
public class SyncAbnormalChangesJobHandler extends IJobHandler {

    @Autowired
    private DataSyncScheduledUtil dataSyncScheduledUtil;

    // fixedDelay = 5 * 60 * 1000
    // cron = "0 0/5 * * * ?"
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        dataSyncScheduledUtil.syncAbnormalChanges();
        return SUCCESS;
    }
}
