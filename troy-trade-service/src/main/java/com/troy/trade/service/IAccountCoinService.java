package com.troy.trade.service;

import com.troy.trade.api.model.dto.in.exchange.admin.AdminExcessCoinInfoReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExcessTurnInfoReqDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExcessTurnInfoResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.PageInfoAdminExcessCoinResDto;
import com.troy.trade.model.domain.account.AccountCoinModel;
import com.troy.trade.model.dto.in.AssetsCoinQueryParamDto;

import java.util.List;

public interface IAccountCoinService {

    /********** admin后台查询相关 开始 ****************/

    /**
     * 获取所有账户的币种总额 分交易所和币种
     * @return
     */
    PageInfoAdminExcessCoinResDto getAccountTotalAssetsByExch(AdminExcessCoinInfoReqDto adminExcessCoinInfoReqDto);

    /**
     * 根据账户ID和币种名称查询币种转移详情
     * @param adminExcessTurnInfoReqDto
     * @return
     */
    AdminExcessTurnInfoResDto getAccountTotalAssetsDetail(AdminExcessTurnInfoReqDto adminExcessTurnInfoReqDto);

    /********** admin后台查询相关 结束 ****************/

    AccountCoinModel getAccountCoin(AssetsCoinQueryParamDto paramDto);

    /**
     * 查询所有数据
     * @param queryCoinMode
     * @return
     */
    List<AccountCoinModel> queryByModel(AccountCoinModel queryCoinMode);

    /**
     * 查询最近更新的数据
     * @param hour
     * @return
     */
    List<AccountCoinModel> queryByHours(int hour);
}
