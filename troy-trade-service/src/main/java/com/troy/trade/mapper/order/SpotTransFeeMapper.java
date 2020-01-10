package com.troy.trade.mapper.order;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.order.SpotTransFeeModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotTransFeeMapper extends BaseMapper<SpotTransFeeModel> {


    void batchInsert(List<SpotTransFeeModel> insertTransFeeModelList);
}