package com.troy.trade.mapper.report;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.report.ExchAcctClearModel;
import com.troy.trade.model.dto.in.report.ExchAcctClearReqDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchAcctClearMapper extends BaseMapper<ExchAcctClearModel> {

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
    int insertBatch(List<ExchAcctClearModel> exchAcctClearModelList);

}