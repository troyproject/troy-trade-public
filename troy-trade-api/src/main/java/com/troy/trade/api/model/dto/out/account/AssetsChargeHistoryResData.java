package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 充币历史
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsChargeHistoryResData extends ResData {
    @ApiModelProperty(value = "充提币历史数组")
    List<AssetsChargeHistoryList> assetsChargeHistoryLists;
}

