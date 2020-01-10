package com.troy.trade.mapper.order;

import com.troy.trade.api.model.dto.in.order.OpenOrderListReqData;
import com.troy.trade.model.domain.order.SpotTransPendingModel;
import com.troy.trade.model.dto.in.GroupByUserAmountDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpotTransPendingHis1Mapper  {


    List<GroupByUserAmountDto> groupByUserAmountDtoList(@Param("startDate") Date startDate, @Param("endDate") Date endDate , @Param("userId") Long userId);

    /**
     * 新增现货当前挂单
     *
     * @param spotTransPending 现货当前挂单
     * @return 结果
     */
    int insertSpotTransPending(SpotTransPendingModel spotTransPending);

    /**
     * 批量新增现货当前挂单
     *
     * @param list 现货当前挂单
     * @return 结果
     */
    int batchInsertHistory(@Param(value = "list") List<SpotTransPendingModel> list);

    /**
     * 查询现货当前挂单列表
     *
     * @param spotTransPending 现货当前挂单
     * @return 现货当前挂单集合
     */
    List<SpotTransPendingModel> selectSpotTransPendingList(SpotTransPendingModel spotTransPending);

    List<SpotTransPendingModel> queryAdminHistoryOrder(OpenOrderListReqData reqData);

    /**
     * 查询交易所最近的交易对
     * @param exchCode
     * @return
     */
    List<String> querySymbolByExchCode(String exchCode);

    /**
     * 根据订单列表批量查询
     * @param reqData
     * @return
     */
    List<SpotTransPendingModel> queryByOrderIds(List<String> reqData);

    /**
     * 查询订单中所有用户
     * @return
     */
    List<String>  queryUserIds();
}
