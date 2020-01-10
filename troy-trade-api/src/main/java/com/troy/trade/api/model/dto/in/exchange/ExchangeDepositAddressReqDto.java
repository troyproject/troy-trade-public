package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 充币地址查询实体
 */
@Setter
@Getter
public class ExchangeDepositAddressReqDto extends ReqData {

    private String exchAcctId;

    /**
     * 币种名称
     */
    private String coinName;

}
