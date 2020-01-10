package com.troy.trade.model.dto.out;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
@Setter
@Getter
public class WalletQueryConfirmDto {
    /**
     * 企业钱包充币唯一码
     */
    private String guid;
    /**
     * 接入方系统提币唯一码
     */
    private String outGuid;
    /**
     * 币种英文缩写（大写）
     */
    private String coinName;
    /**
     * 源地址
     */
    private String sourceAddress;
    /**
     * 目标地址
     */
    private String targetAddress;
    /**
     * 备注
     */
    private String remark;
    /**
     * 数量
     */
    private String amount;
    /**
     * 交易ID
     */
    private String txid;

}
