package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/16
 */
@Setter
@Getter
public class AssetsAccountListResData extends ResData {

    @ApiModelProperty(value = "账户资产-交易所列表")
    private List<AssetsAccountExch> AssetsAccountExchList;
}

