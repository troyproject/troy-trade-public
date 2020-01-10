package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.out.order.OrderDetails;
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
public class OverAssetsListPageInfoResDto extends ResData {

    /**
     * 订单数据
     */
    private List<OverAssetsDetails> list;
    /**
     * 总数量
     */
    private long total;
}
