package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.model.domain.order.SpotTransFeeModel;

import java.util.List;

/**
 *
 */
public interface ISpotTransFeeService extends IBaseService<SpotTransFeeModel> {


    void batchInsert(List<SpotTransFeeModel> insertTransFeeModelList);
}
