package com.troy.trade.model.dto.in.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountAuthListDto implements Serializable {

    private Long accountAuthId;
    private Long userId;
    private Long proxyUserId;
    private String accountName;
    private Integer status;
}
