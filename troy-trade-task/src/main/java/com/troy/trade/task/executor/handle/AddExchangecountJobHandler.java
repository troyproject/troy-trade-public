package com.troy.trade.task.executor.handle;

import com.troy.commons.utils.DateUtils;
import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.service.IExchangeAccountService;
import com.troy.trade.task.executor.schedule.SyncOrderInfoScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 添加同步订单的账户
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="addExchangecount")
@Component
public class AddExchangecountJobHandler extends IJobHandler {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;

    @Autowired
    private IExchangeAccountService exchangeAccountService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("添加同步订单的账户开始---------------当前时间" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME));
        syncOrderInfoScheduledUtil.addSynExchangeAccountOrder(exchangeAccountService.findById(s));
        return SUCCESS;
    }
}
