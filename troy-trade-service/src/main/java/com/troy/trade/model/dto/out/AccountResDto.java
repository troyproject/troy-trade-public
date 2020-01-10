package com.troy.trade.model.dto.out;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * 账户信息列表查询参数实体
 */
@Getter
@Setter
public class AccountResDto extends ResData {

    /**
     * 用户账户ID
     */
    private String accountId;

    /**
     * 账户名称
     */
    private String name;

    /**
     * 账户权限范围，1-只读、2-交易
     */
    private String authResource;

    /**
     * 0自有，1受他人委托
     */
    private Integer myself;


}
