package com.troy.trade.mapper.data;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.data.UsdtPremiumModel;

import java.util.List;

/**
 * USDT溢价操作Dao
 *
 * @author yanping
 */
public interface UsdtPremiumMapper extends BaseMapper<UsdtPremiumModel> {

    /**
     * 获取最新的一条UsdtPremium数据
     * @return
     */
    UsdtPremiumModel getLastUsdtPremium();

    /**
     * 保存实体
     * @param usdtPremiumModelList
     * @return
     */
    int insertBatch(List<UsdtPremiumModel> usdtPremiumModelList);

    /**
     * 查询USDT溢价信息
     * @return
     */
    List<UsdtPremiumModel> getUsdtPremiumModel();
}
