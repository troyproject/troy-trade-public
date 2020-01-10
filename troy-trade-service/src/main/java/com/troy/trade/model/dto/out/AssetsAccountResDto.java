package com.troy.trade.model.dto.out;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/16
 */
@Setter
@Getter
public class AssetsAccountResDto {

    /**
     * accountId
     */
    private Long accountId;
    /**
     * 交易所code
     */
    @ApiModelProperty(value = "交易所code")
    private String exchCode;
    /**
     * 账户类型
     */
    @ApiModelProperty(value = "账户类型")
    private Long accountType;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 所属平台(1troy 2其他平台)
     */
    @ApiModelProperty(value = "所属平台(1troy 2其他平台)")
    private Integer platform;
}
