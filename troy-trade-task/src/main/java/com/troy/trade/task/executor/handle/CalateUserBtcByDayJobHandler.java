package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.task.executor.schedule.SyncOrderInfoScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 计算用户每天的交易量
 *
 * @author sz
 */
@Slf4j
@JobHandler(value="calateUserBtcByDay")
@Component
public class CalateUserBtcByDayJobHandler extends IJobHandler {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;

    // cron = "0 0 11 * * ?"
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncOrderInfoScheduledUtil.calateUserBtcByDay();
        return SUCCESS;
    }
}
