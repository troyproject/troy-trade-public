package com.troy.trade.task.executor.handle;


import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.scheduled.InstrumentsExecute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步合约信息
 */
@Slf4j
@JobHandler(value="syncInstruments")
@Component
public class SyncInstrumentsJobHandler extends IJobHandler {

    @Autowired
    private InstrumentsExecute instrumentsExecute;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        instrumentsExecute.initInstruments();
        return SUCCESS;
    }
}
