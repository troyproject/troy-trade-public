package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import com.troy.commons.utils.CalculateUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 币种超额信息列表字段返回
 *
 * @author yanping
 */
public class AdminExcessCoinInfoResDto extends ResData {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

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

    public String getExchCode() {
        return exchCode;
    }

    public void setExchCode(String exchCode) {
        this.exchCode = exchCode;
    }

    public String getExchName() {
        return exchName;
    }

    public void setExchName(String exchName) {
        this.exchName = exchName;
    }

    public String getExchAcctId() {
        return exchAcctId;
    }

    public void setExchAcctId(String exchAcctId) {
        this.exchAcctId = exchAcctId;
    }

    public String getExchAcctName() {
        return exchAcctName;
    }

    public void setExchAcctName(String exchAcctName) {
        this.exchAcctName = exchAcctName;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(String usableAmount) {
        this.usableAmount = usableAmount;
    }

    public String getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(String frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getExchTotalAmount() {
        return exchTotalAmount;
    }

    public void setExchTotalAmount(String exchTotalAmount) {
        this.exchTotalAmount = exchTotalAmount;
    }

    public String getExchFrozenAmount() {
        return exchFrozenAmount;
    }

    public void setExchFrozenAmount(String exchFrozenAmount) {
        this.exchFrozenAmount = exchFrozenAmount;
    }

    public String getExchUsableAmount() {
        return exchUsableAmount;
    }

    public void setExchUsableAmount(String exchUsableAmount) {
        this.exchUsableAmount = exchUsableAmount;
    }

    public String getExcessAmount() {
        if(StringUtils.isNotBlank(totalAmount) && StringUtils.isNotBlank(exchTotalAmount)){
            excessAmount = CalculateUtil.sub(exchTotalAmount,totalAmount).stripTrailingZeros().toPlainString();
        }
        return excessAmount;
    }

    public void setExcessAmount(String excessAmount) {
        this.excessAmount = excessAmount;
    }
}
