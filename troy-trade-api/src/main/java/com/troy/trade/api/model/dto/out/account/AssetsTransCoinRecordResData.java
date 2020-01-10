package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * 转币历史记录
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
@Builder
public class AssetsTransCoinRecordResData extends ResData {

    @ApiModelProperty(value = "转币记录")
    private List<AssetsTransCoinRecord> transCoinRecordList;

}

