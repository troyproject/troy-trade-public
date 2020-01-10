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
public class WalletApplyCoinOutDto {
    /**
     * 接入方系统提币唯一码
     */
    private String outGuid;
    /**
     * 业务标识码（接入方的业务标识码）
     */
    private String unid;
    /**
     * 业务名称（接入方自定）
     */
    private String bname;
    /**
     * 币种英文缩写（大写）
     */
    private String coinName;
    /**
     * 提币地址（to地址）
     */
    private String coinOutAddress;
    /**
     * 提币数量
     */
    private String amount;
    /**
     * 备注
     */
    private String remark;
    /**
     * 终端来源（IOS、ANDROID、WEB、OTHER）
     */
    private String operateSource;

    /**
     * 终端来源枚举
     */
    public enum OperateSource {
        // IOS、ANDROID、WEB、OTHER
        IOS,
        ANDROID,
        WEB,
        OTHER,
    }
}
