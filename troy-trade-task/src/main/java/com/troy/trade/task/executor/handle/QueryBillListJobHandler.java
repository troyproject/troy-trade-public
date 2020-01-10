package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.util.SyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 归集账单查询
 *
 * @author cj
 */
@Slf4j
@JobHandler(value="queryBillList")
@Component
public class QueryBillListJobHandler extends IJobHandler {

    @Autowired
    private SyncScheduledUtil syncScheduledUtil;

    // cron = "0 0/10 * * * ?"
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        syncScheduledUtil.queryBillListTask();
        return SUCCESS;
    }
}
