package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * 修改交易所的状态和权重
 *
 * @author libohan
 */

public class AdminExchangeUpdateReqDto extends ReqData {

    private Integer exchId;

    private Integer sort;

    private Integer status;

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

    public Integer getExchId() {
        return exchId;
    }

    public void setExchId(Integer exchId) {
        this.exchId = exchId;
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
}
