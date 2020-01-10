package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 提币申请结果
 *
 * @author dp
 */
@Setter
@Getter
public class AccountCoinExtractApplyResDto extends ResData {

    /**
     * accountCoinApplyId
     */
    private Long accountCoinApplyId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 申请人姓名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 账户币种id
     */
    private Long accountCoinId;

    /**
     * TXID
     */
    private String txid;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 提现金额
     */
    private String amount;

    /**
     * 实际到账数量
     */
    private BigDecimal amountActual;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 提现地址
     */
    private String addr;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否保存地址 （0不保存 1保存）
     */
    private Integer saveAddr;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 是否自动审批（1-自动；2-人工）
     */
    private Integer autoApprove;

    /**
     * 审批状态（1-待审核；2-审批通过；3-审批不通过）
     */
    private Integer approveStatus;

    /**
     * 是否足够0不足，1足够
     */
    private Integer enoughAmount;

    /**
     * 审批人
     */
    private String approver;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 是否自动转账（1-是；2-不是）
     */
    private Integer autoTrans;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 审核意见
     */
    private String approverView;

}
