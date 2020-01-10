package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.service.btw.IBtwBalanceRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cq
 *
 */
@Slf4j
@JobHandler(value="btwBalanceRecordsJob")
@Component
public class BtwBalanceRecordsJobHandler extends IJobHandler {

    @Autowired
    private IBtwBalanceRecordsService iBtwBalanceRecordsService;

    /**
     * 0 0 * * * ?
     * @param s
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        iBtwBalanceRecordsService.syncBtwBalanceRecords();
        return SUCCESS;
    }
}
