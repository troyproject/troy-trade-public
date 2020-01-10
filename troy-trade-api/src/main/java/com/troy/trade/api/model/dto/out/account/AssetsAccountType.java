package com.troy.trade.api.model.dto.out.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/21
 */
@Setter
@Getter
public class AssetsAccountType {
    @ApiModelProperty(value = "账户类型 1统一账户 2绑定账户")
    private Integer accountType;
    @ApiModelProperty(value = "账户类型名称")
    private String accountTypeName;
    @ApiModelProperty(value = "账户列表")
    private List<AssetAccount> accountList;
    private String exch_code;
    private Long user_id;
}
