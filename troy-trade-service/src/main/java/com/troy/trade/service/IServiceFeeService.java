package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.out.account.level.AccountLevelResData;
import com.troy.trade.api.model.dto.out.account.level.ServiceFeeResultDto;
import com.troy.trade.model.domain.account.ServiceFeeLevelModel;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
public interface IServiceFeeService extends IBaseService<ServiceFeeLevelModel> {

    /**
     * 查询账户费率
     * @param exchCode
     * @param userId
     * @return
     */
    ServiceFeeResultDto getFeeByUserId(Long userId, String exchCode);


    /**
     * 用户手续费等级信息
     * @param userId
     * @return
     */
    AccountLevelResData level(Long userId);
}
