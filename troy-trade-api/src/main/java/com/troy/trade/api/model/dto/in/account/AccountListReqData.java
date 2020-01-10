package com.troy.trade.api.model.dto.in.account;

import com.troy.trade.api.model.dto.in.AuthReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountListReqData extends AuthReqData {

    private static final long serialVersionUID = 2996290231512350161L;

    private Long userId;
    private Long accountId;
    /**
     * 账户归属
     *
     * @see com.troy.trade.api.model.constant.account.AccountOwnership
     */
    @ApiModelProperty(value = "账户所属，1：Troy；2：其它")
    private Integer accountOwnership;
    private String name;
    /**
     * @see com.troy.trade.api.model.constant.YesOrNo
     */
    private Integer status;

    @ApiModelProperty(value = "排除troy账户，1：排除；0：查询所有账户")
    private Integer excludeType;

    /**
     * 账户类型
     * @see com.troy.trade.api.model.constant.account.AccountTypeEnum
     */
    private Integer accountType;

}