package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.out.order.OrderDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 币种列表字段返回
 *
 * @author yanping
 */
@Setter
@Getter
public class PageInfoAdminExchangeCoinResDto extends ResData {


    /**
     * 币种信息
     */
    private List<AdminExchangeCoinResDto> adminExchangeCoinResDtos;

    /**
     * 总数量
     */
    private long total;
}
