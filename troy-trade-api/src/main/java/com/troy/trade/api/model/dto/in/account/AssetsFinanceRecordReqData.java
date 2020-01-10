package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.in.ReqPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsFinanceRecordReqData extends ReqPage {

    /** 记录类型 0总览 1充币 2提币 3转币 */
    public static final Integer RECORD_TYPE_0 = 0;
    /** 记录类型 0总览 1充币 2提币 3转币 */
    public static final Integer RECORD_TYPE_1 = 1;
    /** 记录类型 0总览 1充币 2提币 3转币 */
    public static final Integer RECORD_TYPE_2 = 2;
    /** 记录类型 0总览 1充币 2提币 3转币 */
    public static final Integer RECORD_TYPE_3 = 3;

    @JsonIgnore
    private Long userId;

    @ApiModelProperty(value = "账户id")
    private Long accountId;

    @ApiModelProperty(value = "记录类型 0总览 1充币 2提币 3转币")
    private Integer recordType;

}
