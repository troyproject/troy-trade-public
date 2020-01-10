package com.troy.trade.model.dto.in.data;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * bitfinex 多空对比数据查询实体
 */
@Getter
@Setter
public class BitfinexPositionRatioReqDto extends ReqData {

    @NotBlank
    private String type;
}
