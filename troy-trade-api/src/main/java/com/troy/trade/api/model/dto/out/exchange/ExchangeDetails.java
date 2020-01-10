package com.troy.trade.api.model.dto.out.exchange;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ExchangeDetails implements Serializable {

    private static final long serialVersionUID = 299624018151223161L;

    private Long id;
    private String code;
    private String name;
    private String aliasName;
    /**
     * 开通账户状态
     *
     * @see com.troy.trade.api.model.constant.exchange.RegisterAccountStatus
     */
    @ApiModelProperty(value = "开通账户状态，0：暂不支持开户；1：联系客服开户；2：支持开户")
    private Integer registerAccountStatus;
    /**
     * 绑定账户状态
     *
     * @see com.troy.trade.api.model.constant.exchange.BindAccountStatus
     */
    @ApiModelProperty(value = "绑定账户状态，0：不支持绑定账户；1：支持绑定账户")
    private Integer bindAccountStatus;
}
