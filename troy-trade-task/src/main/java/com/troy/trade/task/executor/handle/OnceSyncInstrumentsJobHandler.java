package com.troy.trade.task.executor.handle;


import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.scheduled.InstrumentsExecute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 初始合约，币信息
 */
@Slf4j
@JobHandler(value="initInstruments")
@Component
public class OnceSyncInstrumentsJobHandler extends IJobHandler {

    @Autowired
    private InstrumentsExecute instrumentsExecute;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        // s:交易所code，空值初始所有交易所合约币种，币对
        instrumentsExecute.initDbInstruments(s);
        return SUCCESS;
    }
}
