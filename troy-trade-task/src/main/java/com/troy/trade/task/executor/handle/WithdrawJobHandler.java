package com.troy.trade.task.executor.handle;

import com.troy.commons.utils.DateUtils;
import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.constant.ScheduledConstant;
import com.troy.trade.util.DataSyncScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 超额资产转出提现状态同步
 *
 * @author yanping
 */
@Slf4j
@JobHandler(value="withdraw")
@Component
public class WithdrawJobHandler extends IJobHandler {

    @Autowired
    private DataSyncScheduledUtil dataSyncScheduledUtil;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("超额资产转出提现状态同步开始---------------当前时间" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME));
        dataSyncScheduledUtil.syncWithdrawStatus(ScheduledConstant.SYNC_SAVE_TYPE_SYS);
        return SUCCESS;
    }
}
