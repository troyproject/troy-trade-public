package com.troy.trade.model.dto.in;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 账户总资产Dto
 */
@Getter
@Setter
public class AccountTotalAssetsDto extends ReqData{

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 交易所名称
     */
    private String exchName;

    /**
     * 交易所账户ID
     */
    private String exchAcctId;

    /**
     * 交易所账户名称
     */
    private String exchAcctName;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 总额
     */
    private String totalAmount;

    /**
     * 可用额
     */
    private String usableAmount;

    /**
     * 冻结额
     */
    private String frozenAmount;

    /**
     * 交易所账户资产总额
     */
    private String exchTotalAmount;

    /**
     * 交易所账户资产冻结总额
     */
    private String exchFrozenAmount;

    /**
     * 交易所账户资产可用总额
     */
    private String exchUsableAmount;

    /**
     * 超额资产
     */
    private String excessAmount;


}
