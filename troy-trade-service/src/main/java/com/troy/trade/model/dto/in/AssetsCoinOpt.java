package com.troy.trade.model.dto.in;

import com.troy.trade.model.enums.AssetsCoinOptSourceEnum;
import com.troy.trade.model.enums.AssetsCoinOptTypeEnum;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 资产账户币种修改Opt
 *
 * @author zhangchengjie
 * @date 2019/08/19
 */
@Setter
@Getter
@ToString
public class AssetsCoinOpt implements Serializable {

    private static final long serialVersionUID = 2996294331542350161L;

    /**
     * 操作类型 1增加 2减少 3冻结 4解冻 5回滚冻结 6解冻且回滚
     *
     * @see AssetsCoinOptTypeEnum
     */
    private Integer optType;

    /**
     * 操作来源 1交易 2充币 3提币 4转币 5系统 6其他
     *
     * @see AssetsCoinOptSourceEnum
     */
    private Integer optSource;

    /**
     * 账户币种id
     */
    private Long accountCoinId;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 交易号
     */
    private Long spotTransId;

    /**
     * 操作数量
     */
    private BigDecimal optNumber;

    /**
     * 回滚数量
     * <p>
     * use this when optType is (5回滚冻结 6解冻且回滚)
     */
    private BigDecimal rollbackNumber;

    private String updateBy;

    private String createBy;

    private String lastUpdateFromIp;

    public BigDecimal getOptNumber() {
        return optNumber;
    }

    public AssetsCoinOpt() {
    }

    @Builder
    public AssetsCoinOpt(Integer optType, Integer optSource, Long accountCoinId,
                         Long accountId, Long spotTransId, BigDecimal optNumber,
                         BigDecimal rollbackNumber, String updateBy, String createBy,
                         String lastUpdateFromIp) {
        this.optType = optType;
        this.optSource = optSource;
        this.accountCoinId = accountCoinId;
        this.accountId = accountId;
        this.spotTransId = spotTransId;
        this.optNumber = optNumber;
        this.rollbackNumber = rollbackNumber;
        this.updateBy = updateBy;
        this.createBy = createBy;
        this.lastUpdateFromIp = lastUpdateFromIp;
    }

    public void setOptNumber(BigDecimal optNumber) {
        if (optNumber!=null){
            this.optNumber = optNumber.stripTrailingZeros();
        }else {
            this.optNumber = optNumber;
        }

    }

    public BigDecimal getRollbackNumber() {
        return rollbackNumber;
    }

    public void setRollbackNumber(BigDecimal rollbackNumber) {
        if (rollbackNumber!=null){
            this.rollbackNumber = rollbackNumber.stripTrailingZeros();
        }else {
            this.rollbackNumber = rollbackNumber;
        }
    }
}
