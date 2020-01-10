package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.task.executor.schedule.SyncOrderInfoScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步订单详情 币安 ok
 *
 * @author sz
 */
@Slf4j
@JobHandler(value="syncOrderDetails")
@Component
public class SyncOrderDetailsJobHandler extends IJobHandler {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;

    // @Scheduled(fixedDelay = 500000)
    // cron = "0 0 0/1 * * ?"
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncOrderInfoScheduledUtil.syncOrderDetails();
        return SUCCESS;
    }
}
