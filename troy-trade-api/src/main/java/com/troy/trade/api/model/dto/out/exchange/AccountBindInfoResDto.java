package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 调用交易所信息实体
 *
 * @author yanping
 */
@Setter
@Getter
public class AccountBindInfoResDto extends ResData {

    /**
     * 交易所CODE
     */
    private String exchCode;

    /**
     * apiKey
     */
    private String apiKey;

    /**
     * apiSecret
     */
    private String apiSecret;

    /**
     * 密码
     */
    private String passphrase;

    /**
     * 交易所账号ID
     */
    private String thirdAcctId;

    /**
     * 出口IP
     */
    private String exportIp;

    /**
     * 内网IP
     */
    private String intranetIp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 账户绑定ID
     */
    private Long accountBindId;

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 核算币种信息
     */
    private String adjustCoin;

}
