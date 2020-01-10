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
public class WalletExtractCoinQueryReqData {

    private String guid;
    private String unid;
    private String bname;
    private String coinName;
    private String coinOutAddress;
    private String amount;
    private String remark;
    private String operateSource;

}
