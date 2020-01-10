package com.troy.trade.mapper.report;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.report.ExchAcctClearTimeModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchAcctClearTimeMapper extends BaseMapper<ExchAcctClearTimeModel> {

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