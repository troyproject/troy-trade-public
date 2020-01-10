package com.troy.trade.service.report;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.model.domain.report.ExchAcctClearModel;
import com.troy.trade.model.dto.in.report.ExchAcctClearReqDto;

import java.util.List;

/**
 * @author yanping
 */
public interface IExchAcctClearService extends IBaseService<ExchAcctClearModel> {

    /**
     * 根据清算批次ID查找清算信息
     * @param exchAcctClearReqDto
     * @return
     */
    List<ExchAcctClearModel> getByClearTimeId(ExchAcctClearReqDto exchAcctClearReqDto);

    /**
     * 批量保存清算数据
     * @author yanping
     * @param exchAcctClearModelList
     * @return
     */
    int insertBatch(List<ExchAcctClearModel> exchAcctClearModelList) throws Throwable;
}
