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
 * @date 2019/08/16
 */
@Setter
@Getter
public class AssetsAccountListReqData extends ReqData {

    /** 账户资产类型 1我的账户资产 2被授权账户资产 */
    public static final Integer ASSETS_TYPE_1 = 1;
    /** 账户资产类型 2被授权账户资产 */
    public static final Integer ASSETS_TYPE_2 = 2;

    @ApiModelProperty(value = "账户资产类型 1我的账户资产 2被授权账户资产")
    private Integer assetsType;

    @JsonIgnore
    private Long userId;

}
