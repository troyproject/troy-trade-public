package com.troy.trade.model.dto.out.data;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * bitfinex多空对比 数据实体
 *
 * @author yanping
 */
@Getter
@Setter
public class BitfinexPositionRatioChildResDto extends ResData {

    private String time;
    private String vol;
}
