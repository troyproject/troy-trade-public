package com.troy.trade.api.model.dto.out.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsMyselfAccountExch {
    @ApiModelProperty(value = "交易所码")
    private String exchCode;
    @ApiModelProperty(value = "交易所名称")
    private String exchName;
    @ApiModelProperty(value = "账户列表")
    private List<AssetAccount> accountList;
    @ApiModelProperty(value = "交易所币种列表")
    private List<AssetMyselfExchCoin> exchCoinList;

    private Long user_id;
}
