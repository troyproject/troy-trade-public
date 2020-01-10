package com.troy.trade.mapper.order;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.order.SpotTransDetailModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotTransDetailMapper extends BaseMapper<SpotTransDetailModel> {


    void batchInsert(List<SpotTransDetailModel> insertTransFeeModelList);


}
