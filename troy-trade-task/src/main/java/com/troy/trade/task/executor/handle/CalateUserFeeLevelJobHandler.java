package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.task.executor.schedule.SyncOrderInfoScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 计算用户手续费等级
 *
 * @author sz
 */
@Slf4j
@JobHandler(value="calateUserFeeLevel")
@Component
public class CalateUserFeeLevelJobHandler extends IJobHandler {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;

    // cron = "0 0 8 * * ?"
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncOrderInfoScheduledUtil.calateUserFeeLevel();
        return SUCCESS;
    }
}
