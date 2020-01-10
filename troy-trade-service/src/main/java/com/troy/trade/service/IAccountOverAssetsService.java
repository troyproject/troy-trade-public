package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.OverAssetsReqData;
import com.troy.trade.api.model.dto.out.account.OverAssetsListPageInfoResDto;
import com.troy.trade.model.domain.account.AccountBindModel;
import com.troy.trade.model.domain.account.AccountOverAssetsModel;

/**
 * 账户绑定服务
 * @author troy
 */
public interface IAccountOverAssetsService extends IBaseService<AccountOverAssetsModel> {

    /**
     * 初始化超额资产
     */
    void synOverAssets();

    /**
     * 批量增值更新 超额资产
     */
    void synUpdateOverAssets();

    /**
     * 分页查询超额资产列表
     * @param reqData
     * @return
     */
    OverAssetsListPageInfoResDto queryOverAssets(OverAssetsReqData reqData);
}
