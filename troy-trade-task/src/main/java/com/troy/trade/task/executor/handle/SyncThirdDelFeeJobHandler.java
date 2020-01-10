package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.task.executor.schedule.SyncOrderInfoScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步第三方手续费 币安 ok
 *
 * @author sz
 */
@Slf4j
@JobHandler(value="syncThirdDelFee")
@Component
public class SyncThirdDelFeeJobHandler extends IJobHandler {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;
    
    // @Scheduled(fixedDelay = 5000)
    // cron = "0/5 * * * * ?"
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncOrderInfoScheduledUtil.syncThirdDelFeeJob();
        return SUCCESS;
    }
}
