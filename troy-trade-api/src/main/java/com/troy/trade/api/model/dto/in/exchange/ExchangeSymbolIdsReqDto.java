package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExchangeSymbolIdsReqDto extends ReqData {

    private String exchCode;

    List<String> ids;

}
