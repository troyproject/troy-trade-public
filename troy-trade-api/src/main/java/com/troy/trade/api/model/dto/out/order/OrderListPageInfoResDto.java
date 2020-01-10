package com.troy.trade.api.model.dto.out.order;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 链上转账返回实体DTO
 *
 * @author yanping
 */
@Getter
@Setter
public class OrderListPageInfoResDto extends ResData {

    /**
     * 订单数据
     */
    private List<OrderDetails> orderDetailsList;
    /**
     * 总数量
     */
    private long total;
}
