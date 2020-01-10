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
 * 大额转移数据同步
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="blockChainLargeTransfer")
@Component
public class BlockChainLargeTransferJobHandler extends IJobHandler {

    @Autowired
    private DataSyncScheduledUtil dataSyncScheduledUtil;

    // cron = "0 0/30 * * * ?"
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        dataSyncScheduledUtil.syncBlockchainLargetransfer(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
        return SUCCESS;
    }
}
