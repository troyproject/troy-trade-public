package com.troy.trade.api.model.dto.in.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易所账户表
 * @author
 */

@Setter
@Getter
public class ExchangeAccountDto extends ReqData {


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
    @JSONField(serialize = false)
    private String apiSecret;

    /**
     * 私钥密码
     */
    @JSONField(serialize = false)
    private String passphrase;

    /**
     * 资金密码，okex提现用到
     */
    @JSONField(serialize = false)
    private String tradePwd;

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

    /**
     * 充提币短信提醒状态（0：关闭1：开）
     */
    private Integer smsSwitchStatus;

    /**
     * 备注
     */
    private String remark;

}
