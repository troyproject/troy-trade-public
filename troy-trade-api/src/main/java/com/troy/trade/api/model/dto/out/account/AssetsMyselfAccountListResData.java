package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 我的账户列表
 * <p>
 * 主要用于充提币账户查询
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsMyselfAccountListResData extends ResData {

    @ApiModelProperty(value = "充提币-交易所列表")
    private List<AssetsMyselfAccountExch> assetsMyselfAccountExchList;
}

