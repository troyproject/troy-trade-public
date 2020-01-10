package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 币种列表字段返回
 *
 * @author yanping
 */
@Setter
@Getter
public class AdminExchangeCoinResDto extends ResData {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String exchangeCoinId;

    /**
     * 交易所
     */
    private String exchCode;

    /**
     * 币种名称
     */
    private String name;

    /**
     * 启用状态，0-未启用、1-已启用
     */
    private String status;

    /**
     * 是否为计价货币，0-不是、1-是
     */
    private String priceStatus;

    /**
     * 充币状态，0-不可充、1-可充
     */
    private String depositStatus;

    /**
     * 提币状态，0-不可提现、1-可提现
     */
    private String withdrawsStatus;

    /**
     * 转币状态，0-不可用，1-可用
     */
    private String transferStatus;

    /**
     * 排序权重，数值越大越靠前
     */
    private String weight;


    /**
     * 是否代币，1-主币、2-代币
     */
    private String tokensType;

    /**
     * 最后操作时间
     */
    private Date updateTime;

    /**
     * 最后操作人
     */
    private String updateBy;

    /**
     * 最后修改人IP
     */
    private String lastUpdateFromIp;

    public String getExchangeCoinId() {
        return exchangeCoinId;
    }

    public void setExchangeCoinId(String exchangeCoinId) {
        this.exchangeCoinId = exchangeCoinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriceStatus() {
        if(StringUtils.isBlank(priceStatus)){
            priceStatus = "0";
        }
        return priceStatus;
    }

    public void setPriceStatus(String priceStatus) {
        this.priceStatus = priceStatus;
    }

    public String getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus;
    }

    public String getWithdrawsStatus() {
        return withdrawsStatus;
    }

    public void setWithdrawsStatus(String withdrawsStatus) {
        this.withdrawsStatus = withdrawsStatus;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getLastUpdateFromIp() {
        return lastUpdateFromIp;
    }

    public void setLastUpdateFromIp(String lastUpdateFromIp) {
        this.lastUpdateFromIp = lastUpdateFromIp;
    }

    public String getTokensType() {
        if(StringUtils.isBlank(tokensType)){
            tokensType = "1";
        }
        return tokensType;
    }

    public void setTokensType(String tokensType) {
        this.tokensType = tokensType;
    }
}
