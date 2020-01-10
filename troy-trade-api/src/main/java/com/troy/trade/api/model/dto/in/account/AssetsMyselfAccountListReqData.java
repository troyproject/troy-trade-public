package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/16
 */
@Setter
@Getter
public class AssetsMyselfAccountListReqData extends ReqData {

    public static final Integer OPER_TYPE_1 = 1;
    public static final Integer OPER_TYPE_2 = 2;
    public static final Integer OPER_TYPE_3 = 3;

    /** 操作类型 1充币 2提币 3转币 */
    @ApiModelProperty(value = "操作类型 1充币 2提币 3转币")
    private Integer operType;

    @JsonIgnore
    private Long userId;

}
