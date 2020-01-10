package com.troy.trade.mapper.order;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.order.SpotTransPendingTempModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotTransPendingTempMapper extends BaseMapper<SpotTransPendingTempModel> {

    int batchInsertHistory(@Param(value = "list") List<SpotTransPendingTempModel> list);

}
