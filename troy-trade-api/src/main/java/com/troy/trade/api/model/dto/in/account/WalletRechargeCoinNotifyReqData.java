package com.troy.trade.api.model.dto.in.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangchengjie
 * @date 2019/09/04
 */
@Setter
@Getter
@ToString
public class WalletRechargeCoinNotifyReqData {

    private String guid;
    private String coinName;
    private String sourceAddress;
    private String targetAddress;
    private String amount;
    private String remark;
    private String txid;
    private String affirmNo;
    private String pullTime;
    private String unid;
    private String bname;

}
