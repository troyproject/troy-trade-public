package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeCodeResDto extends ReqData {

    private String exchCode;

    // 1正常 0 禁用
    private Integer status;

    private String coinName;


}
