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
public class WalletExtractCoinQueryResDto {

    /** 状态(1:待处理；2:已打币；3:已拒绝；4已确认)*/
    public static final Integer STATUS_1 = 1;
    /** 状态(1:待处理；2:已打币；3:已拒绝；4已确认)*/
    public static final Integer STATUS_2 = 2;
    /** 状态(1:待处理；2:已打币；3:已拒绝；4已确认)*/
    public static final Integer STATUS_3 = 3;
    /** 状态(1:待处理；2:已打币；3:已拒绝；4已确认)*/
    public static final Integer STATUS_4 = 4;

    /**
     * 接入方系统提币唯一码
     */
    private String outGuid;
    /**
     * 拒绝原因
     */
    private String rejectCause;
    /**
     * 状态(1:待处理；2:已打币；3:已拒绝；4已确认)
     */
    private Integer status;
    /**
     * 交易ID
     */
    private String txid;
    /**
     * 区块高度
     */
    private String blockHeight;
    /**
     * 确认数
     */
    private String confirm;
    /**
     * 交易源(1:自动；2:手动 ：3: 待定）
     */
    private Integer txidSource;
    /**
     * 矿工费
     */
    private String fee;
    /**
     * 付费货币
     */
    private String feeName;
    /**
     * 修改时间
     */
    private Long updateTime;

}
