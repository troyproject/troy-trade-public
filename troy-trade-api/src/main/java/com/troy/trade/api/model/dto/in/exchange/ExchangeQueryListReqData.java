package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


/**
 * @author Han
 */
@Setter
@Getter
public class ExchangeQueryListReqData extends ReqData {

    private static final long serialVersionUID = 2996290992341550161L;

    /**
     * 开通账户状态
     *
     * @see com.troy.trade.api.model.constant.exchange.RegisterAccountStatus
     */
    @ApiModelProperty(value = "开通账户状态，0：暂不支持开户；1：联系客服开户；2：支持开户。如：开通账户业务需要传入参数[1,2]")
    private Set<Integer> registerAccountStatusList;
    /**
     * 绑定账户状态
     *
     * @see com.troy.trade.api.model.constant.exchange.BindAccountStatus
     */
    @ApiModelProperty(value = "绑定账户状态，0：不支持绑定账户；1：支持绑定账户。如：绑定账户业务需要传入参数1")
    private Integer bindAccountStatus;
}
