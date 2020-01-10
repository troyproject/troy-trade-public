package com.troy.trade.api.model.dto.in.account.auth;

import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountAuthAddReqData extends ReqData {

    private static final long serialVersionUID = 2996290941542350161L;

    private Long accountId;
    @ApiModelProperty(value = "用户邮箱或手机")
    private String username;
    /**
     * @see com.troy.trade.api.model.constant.account.AccountPermissionType
     */
    @ApiModelProperty(value = "权限类型，1：只读；2：交易")
    private Integer permissionType;
}
