package com.troy.trade.api.model.dto.out.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/21
 */
@Setter
@Getter
public class AssetAccount {
    @ApiModelProperty(value = "账户id")
    private Long accountId;
    @ApiModelProperty(value = "账户名称")
    private String name;
}
