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
public class AssetsAccountExch {
    @ApiModelProperty(value = "交易所码")
    private String exchCode;
    @ApiModelProperty(value = "交易所名称")
    private String exchName;
    @ApiModelProperty(value = "账户类型列表")
    private List<AssetsAccountType> accountTypeList;
    private Long user_id;
}
