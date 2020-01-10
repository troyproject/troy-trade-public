package com.troy.trade.api.model.dto.out.order;

import com.troy.commons.dto.out.ResData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 创建订单返回参数
 *
 * @author dp
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSpotOrderResDto extends ResData {

    /**
     * 返回平台的订单号
     */
    private String transId;
}
