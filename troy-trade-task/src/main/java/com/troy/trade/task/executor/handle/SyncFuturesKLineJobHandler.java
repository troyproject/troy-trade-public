package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.scheduled.FuturesTickerExecute;
import com.troy.trade.scheduled.KLineExecute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步合约k线
 */
@Slf4j
@JobHandler(value = "syncFuturesKLine")
@Component
public class SyncFuturesKLineJobHandler extends IJobHandler {

    @Autowired
    private KLineExecute kLineExecute;

    @Autowired
    private FuturesTickerExecute futuresTickerExecute;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        kLineExecute.futuresKline();
        return SUCCESS;
    }
}
