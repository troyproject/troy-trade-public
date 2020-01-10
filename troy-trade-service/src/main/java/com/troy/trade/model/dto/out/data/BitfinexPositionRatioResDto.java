package com.troy.trade.model.dto.out.data;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * bitfinex多空对比 数据实体
 *
 * @author yanping
 */
@Getter
@Setter
public class BitfinexPositionRatioResDto extends ResData {
    private List<BitfinexPositionRatioChildResDto> longs;
    private List<BitfinexPositionRatioChildResDto> shorts;
    private String longRatio;
    private String shortRatio;
}
