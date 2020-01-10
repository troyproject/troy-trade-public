package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/19
 */
@Setter
@Getter
public class AssetsAccountCoinReqData extends ReqData {

    @ApiModelProperty(value = "账户id")
    private Long accountId;
    @ApiModelProperty(value = "隐藏小额资产 0不隐藏（默认） 1隐藏")
    private Integer hideSmallAmount;
    @JsonIgnore
    private String exchCode;
    @JsonIgnore
    private Long userId;
    @ApiModelProperty(value = "账户类型")
    private Integer accountOwnership;

}
