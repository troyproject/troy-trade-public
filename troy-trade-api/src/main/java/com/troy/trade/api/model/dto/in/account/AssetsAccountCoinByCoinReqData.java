package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 交易所币种估值btcamount请求
 */
@Setter
@Getter
public class AssetsAccountCoinByCoinReqData extends ReqData {

    @ApiModelProperty(value = "账户id")
    private Long accountId;

    private String exchCode;

    private String coinName;

}
