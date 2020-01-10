package com.troy.trade.service.report;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.model.domain.report.ExchAcctClearTimeModel;

import java.util.List;

/**
 * @author yanping
 */
public interface IExchAcctClearTimeService extends IBaseService<ExchAcctClearTimeModel> {

    /**
     * 根据交易所code获取一条账户信息
     * @return
     */
    ExchAcctClearTimeModel getLastClearTime();

    /**
     * 批量保存数据
     * @author yanping
     * @throws Throwable
     */
    int insertBatch(List<ExchAcctClearTimeModel> clearTimeList);
}
