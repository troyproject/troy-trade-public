package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户转币传参调用zcj接口参数DTO
 */
@Setter
@Getter
public class AccountCoinTellerOperationReqDto extends ReqData {


    /**
     * accountCoinTellerId
     */
    private Long accountCoinTellerId;


    /**
     * 操作类型 1提币到交易所 2添加资产
     */
    private Integer operType;

}
