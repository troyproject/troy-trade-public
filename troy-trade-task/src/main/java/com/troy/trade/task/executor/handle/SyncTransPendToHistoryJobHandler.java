package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.task.executor.schedule.SyncOrderInfoScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 将挂单表数据同步到历史表
 *
 * @author sz
 */
@Slf4j
@JobHandler(value="syncTransPendToHistory")
@Component
public class SyncTransPendToHistoryJobHandler extends IJobHandler {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;

    // @Scheduled(fixedDelay = 5000)
    // cron = "0/5 * * * * ?"
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncOrderInfoScheduledUtil.syncTransPendToHistory();
        return SUCCESS;
    }
}
