package com.troy.trade.service;


import com.troy.commons.dto.out.Res;
import com.troy.trade.api.model.dto.in.order.CancelSpotOrderReqDto;
import com.troy.trade.api.model.dto.in.order.CreateSpotOrderReqDto;
import com.troy.trade.api.model.dto.in.order.OpenOrderListReqData;
import com.troy.trade.api.model.dto.out.order.CancelSpotOrderResDto;
import com.troy.trade.api.model.dto.out.order.CreateSpotOrderResDto;
import com.troy.trade.api.model.dto.out.order.OrderDetails;
import com.troy.trade.api.model.dto.out.order.OrderListPageInfoResDto;
import com.troy.trade.exchange.api.model.dto.out.market.MyTradeResDto;
import com.troy.trade.model.domain.order.SpotTransPendingModel;
import com.troy.trade.model.dto.in.OrderModifyDto;
import com.troy.user.dto.in.user.UserRightReqData;

import java.util.List;

/**
 * 订单相关服务
 *
 * @author dp
 */
public interface IOrderService {

    /**
     * 创建币币订单服务
     *
     * @param createSpotOrderReqDto
     * @return
     */
    Res<CreateSpotOrderResDto> createSpotOrder(CreateSpotOrderReqDto createSpotOrderReqDto);

    /**
     * 撤销币币订单服务
     *
     * @param cancelSpotOrderReqDto
     * @return
     */
    Res<CancelSpotOrderResDto> cancelSpotOrder(CancelSpotOrderReqDto cancelSpotOrderReqDto);

    /**
     * 订单状态更新后修改transFlow状态及更新限额
     *
     * @param orderModifyDto
     * @return
     */
    void modifyOrder(OrderModifyDto orderModifyDto, SpotTransPendingModel transFlow, List<MyTradeResDto> myTradeResDtoList);


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
     * 获取用户交易权限
     *  返回数据为1的时候为有权限
     * @param userId
     * @param type com.troy.trade.api.model.constant.UserTradeRightEnum
     * @return
     */
    Integer getUserTradeRight(Long userId, int type);

}
