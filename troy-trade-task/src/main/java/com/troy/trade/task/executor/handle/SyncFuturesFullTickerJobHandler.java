package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.scheduled.FuturesTickerExecute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步合约ticker
 */
@Slf4j
@JobHandler(value="syncFuturesFullTicker")
@Component
public class SyncFuturesFullTickerJobHandler extends IJobHandler {

    @Autowired
    private FuturesTickerExecute futuresTickerExecute;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        futuresTickerExecute.ticker();
        return SUCCESS;
    }
}
