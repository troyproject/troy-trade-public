package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExchangeListParentResDto extends ResData {

    private List<ExchangeParentResDto> exchangeParentResDtoList;
}
