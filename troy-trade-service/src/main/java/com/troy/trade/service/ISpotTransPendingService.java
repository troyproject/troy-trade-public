package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.order.OpenOrderListReqData;
import com.troy.trade.api.model.dto.out.order.OrderDetails;
import com.troy.trade.api.model.dto.out.order.OrderListPageInfoResDto;
import com.troy.trade.model.domain.order.SpotTransPendingModel;
import com.troy.trade.model.dto.in.AssetsCoinOpt;
import com.troy.trade.model.dto.in.SpotTransLimitReqDto;
import com.troy.trade.model.dto.out.SpotTransLimitResDto;

import java.util.List;

/**
 * 币币交易当前挂单服务
 *
 * @author dp
 */
public interface ISpotTransPendingService extends IBaseService<SpotTransPendingModel> {

    /**
     * 币币交易下单前存库
     *
     * @param assetsCoinOpt
     * @param spotTransPendingModel
     * @param needFrozen
     * @return
     */
    int beforeCreateSportOrderSave(AssetsCoinOpt assetsCoinOpt, SpotTransPendingModel spotTransPendingModel, boolean needFrozen);

    /**
     * 新事物更新比比价交易当前挂单
     *
     * @param spotTransPendingModel
     * @return
     */
    int updateSpotTransPendingRequiresNew(SpotTransPendingModel spotTransPendingModel);

    /**
     * 新事物批量更新币币交易挂单状态
     *
     * @param spotTransPendingModels
     * @param userId
     * @return
     */
    int batchCancelUpdateRequiresNew(List<SpotTransPendingModel> spotTransPendingModels, String userId,Integer source);

    /**
     * 根据账户和交易对查询未完成的订单列表（返回主键和orderId）
     *
     * @param accountId
     * @param exchSymbolId
     * @return
     */
    List<SpotTransPendingModel> queryUnFinishOrder(Long accountId, String exchSymbolId, Integer source);

    /**
     * 完全成交
     * @param reqData
     * @return
     */
    OrderListPageInfoResDto queryComplateSucessOpenOrder(OpenOrderListReqData reqData) ;

    /**
     * 历史委托
     * @param reqData
     * @return
     */
    OrderListPageInfoResDto queryHistoryOpenOrder(OpenOrderListReqData reqData);

    /**
     * 当前委托
     * @param reqData
     * @return
     */
    List<OrderDetails> queryCurrentOrder(OpenOrderListReqData reqData);

    /**
     * 将挂单表数据同步到历史表
     *
     * @throws Exception
     */
    void syncTransPendToHistory();

    /**
     * 后台管理历史委托查询
     * @param reqData
     * @return
     */
    OrderListPageInfoResDto queryAdminHistoryOrder(OpenOrderListReqData reqData);


    /**
     * 后台管理当前挂单查询
     * @param reqData
     * @return
     */
    OrderListPageInfoResDto queryAdminCurrentOrder(OpenOrderListReqData reqData);

    /**
     * 查询用户在交易所下的当前挂单数量
     *
     * @param spotTransLimitReqDto
     * @return
     */
    List<SpotTransLimitResDto> querySpotTransLimit(SpotTransLimitReqDto spotTransLimitReqDto);

    /**
     * 更新订单挂单表 状态 2和3 不更新
     * @param spotTransPendingModelUpdate
     * @return
     */
    int updateByStatus(SpotTransPendingModel spotTransPendingModelUpdate);

    /**
     * 查询交易所最近的交易对
     * @param exchCode
     * @return
     */
    List<String> querySymbolByExchCode(String exchCode);
}
