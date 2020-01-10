package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.constant.ScheduledConstant;
import com.troy.trade.util.DataSyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 交易所账户清算报表
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="clearingJobHandler")
@Component
public class ClearingJobHandler extends IJobHandler {

    @Autowired
    private DataSyncScheduledUtil dataSyncScheduledUtil;

    // cron = "0 0 0/1 * * ?"
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        dataSyncScheduledUtil.dealExchAcctClear(ScheduledConstant.SYNC_SAVE_TYPE_SYS,ScheduledConstant.EXCH_ACCT_CLEAR_ALL);
        return SUCCESS;
    }
}
