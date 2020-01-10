package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sz
 */
@Setter
@Getter
public class OverAssetsDetails extends ResData {


    /**
     * accountCoinId
     */

    private Long accountOverAssetsId;
    /**
     * 账户id
     */

    private Long walletAccountId;

    /**
     * 交易所code
     */

    private String exchCode;

    /**
     * 币种名称
     */

    private String coinName;
    /**
     * 总额
     */

    private java.math.BigDecimal overAssets;
    /**
     * 总额
     */

    private java.math.BigDecimal totalAmount;
    /**
     * 可用额
     */

    private java.math.BigDecimal usableAmount;
    /**
     * 冻结额
     */

    private java.math.BigDecimal frozenAmount;


    /**
     * 总额
     */

    private java.math.BigDecimal walletTotalAmount;
    /**
     * 可用额
     */

    private java.math.BigDecimal walletUsableAmount;
    /**
     * 冻结额
     */

    private java.math.BigDecimal walletFrozenAmount;

    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String lastUpdateFromIp;

}
