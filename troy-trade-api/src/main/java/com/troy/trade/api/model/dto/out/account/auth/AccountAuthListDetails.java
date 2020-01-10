package com.troy.trade.api.model.dto.out.account.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountAuthListDetails implements Serializable {

    private static final long serialVersionUID = 299629093253241161L;

    private Long id;
    private Long accountAuthId;
    private String exchangeCode;
    private String accountName;
    private String username;
    private String proxyUsername;
    /**
     * 权限类型
     *
     * @see com.troy.trade.api.model.constant.account.AccountPermissionType
     */
    @ApiModelProperty(value = "权限类型，1：只读；2：交易")
    private Integer permissionType;

    /**
     * btc资产净值
     */
    private BigDecimal btcCount;
    /**
     * cny资产净值
     */
    private BigDecimal cnyCount;
}
