package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsChargeHistoryReqData extends ReqData {

    @JsonIgnore
    private Long userId;

    @ApiModelProperty(value = "账户币种id")
    private Long accountCoinId;

    @ApiModelProperty(value = "查询类型 1充币 2提币")
    private Long operType;

}
