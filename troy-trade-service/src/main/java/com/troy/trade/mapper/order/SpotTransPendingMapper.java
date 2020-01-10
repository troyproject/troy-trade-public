package com.troy.trade.mapper.order;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.order.OpenOrderListReqData;
import com.troy.trade.model.domain.order.SpotTransPendingModel;
import com.troy.trade.model.dto.in.SpotTransLimitReqDto;
import com.troy.trade.model.dto.out.SpotTransLimitResDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SpotTransPendingMapper extends BaseMapper<SpotTransPendingModel> {

    /**
     * 批量更新新库存
     *
     * @param list
     * @return
     */
    int updateBatch(@Param(value = "list") List<SpotTransPendingModel> list);

    /**
     * 根据账户和交易对查询未完成的订单列表（返回主键和orderId）
     *
     * @param params
     * @return
     */
    List<SpotTransPendingModel> queryUnFinishOrder(Map<String, Object> params);

    /**
     * 查询用户在交易所下的当前挂单数量
     *
     * @param spotTransLimitReqDto
     * @return
     */
    List<SpotTransLimitResDto> querySpotTransLimit(SpotTransLimitReqDto spotTransLimitReqDto);

    /**
     * 批量更新订单撤销申请状态
     *
     * @param params
     * @return
     */
    int batchCancelUpdateRequiresNew(Map<String, Object> params);


    List<SpotTransPendingModel> queryBakOpenOrder(OpenOrderListReqData reqData);


    int batchInsertHistory(@Param(value = "list") List<SpotTransPendingModel> list);

    int updateByStatus(SpotTransPendingModel spotTransPendingModelUpdate);
}
