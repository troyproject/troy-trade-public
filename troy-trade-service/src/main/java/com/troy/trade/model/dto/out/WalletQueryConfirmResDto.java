package com.troy.trade.model.dto.out;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/09/04
 */
@Setter
@Getter
public class WalletQueryConfirmResDto {
    /**
     * 接入方系统提币唯一码
     */
    private String outGuid;
    /**
     * 确认数
     */
    private String confirm;
    /**
     * 币种英文名称
     */
    private String coinName;
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
