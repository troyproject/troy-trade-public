package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinBaseReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinDetailReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchangeCoinDetailResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchangeCoinResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.PageInfoAdminExchangeCoinResDto;
import com.troy.trade.model.domain.exchange.ExchangeCoinModel;

import java.util.List;

public interface IExchangeCoinService extends IBaseService<ExchangeCoinModel> {

    /**
     * 批量保存数据
     * @param exchangeCoinModelList
     * @return
     * @throws Throwable
     */
    int insertBatch(List<ExchangeCoinModel> exchangeCoinModelList) throws Throwable;

    /**
     * 批量修改数据
     * @param exchangeCoinModelList
     * @return
     */
    int updateBatch(List<ExchangeCoinModel> exchangeCoinModelList) throws Throwable;

    /**
     * 根据交易所code获取币种列表
     * @param exchangeCodeResDto
     * @author yanping
     * @return
     */
    List<ExchangeCoinModel> getExchangeCoinModelByExchCode(ExchangeCodeResDto exchangeCodeResDto);

    /**
     * 添加币种
     *
     * @return
     */
    int addCoin(ExchangeCodeResDto data);

    /**
     * 筛选出所有币种，不区分交易所
     * @return
     */
    List<ExchangeCoinModel> selectList();

    /********** admin后台查询相关 开始 ****************/

    /**
     * 根据查询条件获取币种列表
     * @return
     */
    PageInfoAdminExchangeCoinResDto getAdminExchangeCoinResDtos(AdminExchangeCoinReqDto adminExchangeCoinReqDto);

    /**
     * 根据币种ID查找币种的基础信息
     * @param adminExchangeCoinReqDto
     * @author yanping
     * @return
     */
    AdminExchangeCoinResDto getAdminCoinBase(AdminExchangeCoinReqDto adminExchangeCoinReqDto);

    /**
     * 根据参数修改币种基础信息
     * @param adminExchangeCoinBaseReqDto
     * @author yanping
     * @return
     */
    Integer updateExchCoinBase(AdminExchangeCoinBaseReqDto adminExchangeCoinBaseReqDto);

    /**
     * 根据币种ID查找币种的详细信息
     * @param adminExchangeCoinReqDto
     * @author yanping
     * @return
     */
    AdminExchangeCoinDetailResDto getAdminCoinDetail(AdminExchangeCoinReqDto adminExchangeCoinReqDto);

    /**
     * 根据参数修改币种详细信息
     * @param adminExchangeCoinDetailReqDto
     * @author yanping
     * @return
     */
    Integer updateExchCoinDetail(AdminExchangeCoinDetailReqDto adminExchangeCoinDetailReqDto) throws Throwable;

    /********** admin后台查询相关 结束 ****************/
}
