package com.troy.trade.api.model.dto.out.account;

import lombok.Getter;
import lombok.Setter;

/**
 * 调用交易所信息实体
 *
 * @author dp
 */
@Setter
@Getter
public class CallExchangeInfoAccountResDto extends CallExchangeInfoNoDecodeResDto {

    private String privateKey;
}
