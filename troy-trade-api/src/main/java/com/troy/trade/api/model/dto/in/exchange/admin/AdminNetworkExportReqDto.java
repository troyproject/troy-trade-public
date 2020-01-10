package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;

import java.util.Date;

/**
 * @author libohan
 */

public class AdminNetworkExportReqDto extends ReqData {

    private String exportIp;

    private String hostName;

    private String userAccount;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getExportIp() {
        return exportIp;
    }

    public void setExportIp(String exportIp) {
        this.exportIp = exportIp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
