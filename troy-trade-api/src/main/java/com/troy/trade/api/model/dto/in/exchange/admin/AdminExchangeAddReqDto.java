package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;

import java.util.Date;

/**
 * 修改交易所的状态和权重
 *
 * @author libohan
 */

public class AdminExchangeAddReqDto extends ReqData {

    private Long exchId;

    private String exchName;

    private String exchCode;

    private String aliasName;

    private Integer sort;

    private Integer status;

    public String getExchCode() {
        return exchCode;
    }

    public void setExchCode(String exchCode) {
        this.exchCode = exchCode;
    }

    public Long getExchId() {
        return exchId;
    }

    public void setExchId(Long exchId) {
        this.exchId = exchId;
    }

    public String getExchName() {
        return exchName;
    }

    public void setExchName(String exchName) {
        this.exchName = exchName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
