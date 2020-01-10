package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 超额资产划转信息实体
 * @author yanping
 */
@Getter
@Setter
public class AdminExcessTurnInfoSaveResDto extends ResData {

    /**
     * 转出交易所code
     */
    private String outExchCode;

    /**
     * 转出交易所名称
     */
    private String outExchName;

    /**
     * 转出交易所账户ID
     */
    private String outExchAcctId;

    /**
     * 转出交易所账户名称
     */
    private String outExchAcctName;

    /**
     * 转入交易所code
     */
    private String inExchCode;

    /**
     * 转入交易所名称
     */
    private String inExchName;

    /**
     * 转入交易所账户ID
     */
    private String inExchAcctId;

    /**
     * 转入交易所账户名称
     */
    private String inExchAcctName;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 超额资产
     */
    private String excessAmount;

    /**
     * 划转资产
     */
    private String transferAmount;


}
