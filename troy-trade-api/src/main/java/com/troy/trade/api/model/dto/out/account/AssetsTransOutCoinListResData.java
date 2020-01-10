package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 转出币种
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsTransOutCoinListResData extends ResData {

    @ApiModelProperty(value = "转出币种")
    private List<AssetsTransOutCoinResData> transOutCoinList;

}

