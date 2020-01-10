package com.troy.trade.api.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ExchangeAccountReqDto  extends ReqPage {

    private Long exchAcctId;

    /**
     * 交易所ID
     */
    private Long exchId;

    /**
     * 交易所CODE
     */
    private String exchCode;

    /**
     * 三方账户ID
     */
    private String thirdAcctId;

    /**
     * 账户名称
     */
    private String acctName;

    /**
     * ak
     */
    private String apiKey;

    /**
     * sk
     */
    private String apiSecret;

    /**
     * 私钥密码
     */
    private String passphrase;

    /**
     * 状态（0-禁用，1-启用）
     */
    private Integer status;

    /**
     * 出口IP
     */
    private String exportIp;

    /**
     * 解密私钥
     */
    private String privateKey;

    private String createBy;

    private Date createTime;

    /**
     * 充提币短信提醒状态（0：关闭1：开）
     */
    private Integer smsSwitchStatus;

    /**
     * 备注
     */
    private String remark;

}
