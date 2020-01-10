package com.troy.trade.service.data;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.exchange.api.model.dto.out.data.DataListResDto;
import com.troy.trade.model.domain.data.UsdtPremiumModel;

import java.util.List;

/**
 * 服务接口
 *
 * @author yanping
 */
public interface IUsdtPremiumService extends IBaseService<UsdtPremiumModel> {

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
     * 做数据信息同步及保存
     * @throws Throwable
     */
    Integer syncUsdtPremium();

    /**
     * 溢价数据信息查询
     * @return
     */
    DataListResDto getUsdtPremium();
}
