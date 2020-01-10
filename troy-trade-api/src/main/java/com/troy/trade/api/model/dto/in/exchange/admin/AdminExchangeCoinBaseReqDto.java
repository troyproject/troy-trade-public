package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 币种列表字段返回
 *
 * @author yanping
 */
public class AdminExchangeCoinBaseReqDto extends ReqData {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String exchangeCoinId;

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
     * 转币状态，0-不可 1-可
     */
    private String transferStatus;

    /**
     * 排序权重，数值越小越靠前
     */
    private Integer weight;

    /**
     * 是否代币，1-主币、2-代币
     */
    private Integer tokensType;

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

    /**
     * 币种操作状态，0-不可提币不可充币、1-可提币可充币、2-只可提币、3-只可充币
     */
    private Integer operationStatus;

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
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

    public Integer getOperationStatus() {
        if(StringUtils.isBlank(depositStatus) && StringUtils.isBlank(withdrawsStatus)){
            operationStatus = 0;
        }else if(StringUtils.equals(depositStatus,"1") && StringUtils.equals(withdrawsStatus,"1")){
            operationStatus = 1;
        }else if(StringUtils.equals(depositStatus,"0")  && StringUtils.equals(withdrawsStatus,"1")){
            operationStatus = 2;
        }else if(StringUtils.equals(depositStatus,"1") && StringUtils.equals(withdrawsStatus,"0")){
            operationStatus = 3;
        }else{
            operationStatus = 0;
        }
        return operationStatus;
    }

    public void setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Integer getTokensType() {
        return tokensType;
    }

    public void setTokensType(Integer tokensType) {
        this.tokensType = tokensType;
    }
}
