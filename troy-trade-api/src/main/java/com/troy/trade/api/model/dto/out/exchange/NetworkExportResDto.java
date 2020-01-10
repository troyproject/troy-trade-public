package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NetworkExportResDto extends ResData {

    private String networkExportId;

    /**
     * 内网IP
     */
    private String intranetIp;

    /**
     * 内网服务调用地址
     */
    private String intranetUrl;

    /**
     * 外网IP
     */
    private String exportIp;


    /**
     * 状态 0-禁用 1-启用
     */
    private Integer status;

    /**
     * 主机名
     */
    private String hostName;

    /**
     * 描述
     */
    private String des;


    /**
     * 绑定账户
     */
    private String userAccount;

}
