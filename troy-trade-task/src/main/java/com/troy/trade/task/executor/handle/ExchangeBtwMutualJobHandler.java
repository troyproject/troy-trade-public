package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.service.IExchangeBtwMutualTransferService;
import com.troy.trade.service.btw.IBtwBalanceRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 从交易所划转到btw账户时，扫描btw是否到账，并更新状态，txid 交易流水号
 * @author cq
 *
 */
@Slf4j
@JobHandler(value="exchangeBtwMutualRecordsJob")
@Component
public class ExchangeBtwMutualJobHandler extends IJobHandler {

    @Autowired
    private IExchangeBtwMutualTransferService mutualTransferService;

    // 0 */5 * * * ?
    /**
     * 每5分钟执行
     * @param s
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        mutualTransferService.schedulerUpdateDrawStatus();
        return SUCCESS;
    }
}
