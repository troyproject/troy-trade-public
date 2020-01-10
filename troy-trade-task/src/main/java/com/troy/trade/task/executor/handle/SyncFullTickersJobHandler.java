package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.constant.ScheduledConstant;
import com.troy.trade.util.SyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 全部ticker信息同步
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="syncFullTickers")
@Component
public class SyncFullTickersJobHandler extends IJobHandler {

    @Autowired
    private SyncScheduledUtil syncScheduledUtil;

    // fixedDelay = 5000
    // cron = "0/5 * * * * ?"
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        syncScheduledUtil.syncAllTIckers(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
        return SUCCESS;
    }
}
