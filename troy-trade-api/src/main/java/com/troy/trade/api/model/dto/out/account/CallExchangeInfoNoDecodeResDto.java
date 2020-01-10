package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CallExchangeInfoNoDecodeResDto extends ResData {

    /**
     * 交易所CODE
     */
    protected String exchCode;

    /**
     * apiKey
     */
    protected String apiKey;

    /**
     * apiSecret
     */
    protected String apiSecret;

    /**
     * 密码
     */
    protected String passphrase;

    /**
     * 交易所账号ID
     */
    protected String thirdAcctId;

    /**
     * 交易密码
     */
    protected String tradePwd;

    /**
     * 出口IP
     */
    protected String exportIp;

    /**
     * 内网IP
     */
    protected String intranetIp;

    /**
     * 创建时间
     */
    protected Date createTime;
}
