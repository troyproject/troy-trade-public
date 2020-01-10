package com.troy.trade.api.model.dto.out.exchange;

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
public class ExchangeTransferRecordPageInfoResDto extends ResData {


    private List<ExchangeTransferRecordsRes> list;
    /**
     * 总数量
     */
    private long total;
}
