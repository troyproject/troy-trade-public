package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 超额资产划转信息实体
 * @author yanping
 */
@Getter
@Setter
public class AdminExcessTurnInfoSaveReqDto extends ReqData {

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
    private BigDecimal excessAmount;

    /**
     * 划转资产
     */
    private BigDecimal transferAmount;

    /**
     * 操作方向，1-转入、2-转出
     */
    private String operationType;

    /**
     * 创建者
     */
    protected String createBy;

    /**
     * 创建日期
     */
    protected Date createTime;

    /**
     * 最后修改人IP
     */
    protected String lastUpdateFromIp;


}
