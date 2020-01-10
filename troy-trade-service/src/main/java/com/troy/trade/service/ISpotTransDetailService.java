package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.model.domain.order.SpotTransDetailModel;

import java.util.List;

/**
 *
 */
public interface ISpotTransDetailService extends IBaseService<SpotTransDetailModel> {


    /**
     * 批量插入
     * @param insertTransFeeModelList
     */
    void batchInsert(List<SpotTransDetailModel> insertTransFeeModelList);
}
