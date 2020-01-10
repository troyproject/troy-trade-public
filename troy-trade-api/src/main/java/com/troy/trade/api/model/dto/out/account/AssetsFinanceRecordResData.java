package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * 财务记录
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
//@Builder
public class AssetsFinanceRecordResData extends ResData {

    @ApiModelProperty(value = "财务记录")
    private List<AssetsFinanceRecord> AssetsFinanceRecordList;

    /**
     * 总数量
     */
    private long total;

}

