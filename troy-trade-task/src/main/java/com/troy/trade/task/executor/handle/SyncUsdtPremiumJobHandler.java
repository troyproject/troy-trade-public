package com.troy.trade.task.executor.handle;

import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.service.data.IUsdtPremiumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * usdt与USD溢价数据
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="syncUsdtPremium")
@Component
public class SyncUsdtPremiumJobHandler extends IJobHandler {

    @Autowired
    private IUsdtPremiumService usdtPremiumService;

    // cron = "0 0/30 * * * ?"
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        usdtPremiumService.syncUsdtPremium();
        return SUCCESS;
    }
}
