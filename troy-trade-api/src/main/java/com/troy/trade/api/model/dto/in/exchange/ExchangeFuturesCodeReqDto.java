package com.troy.trade.api.model.dto.in.exchange;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeFuturesCodeReqDto extends ExchangeCodeReqDto {

    /**
     * this_week
     * next_week
     * quarter
     */
    private String alias;

    // 1正常 0 禁用
    private Integer status;

    private String coinName;

}
