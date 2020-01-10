package com.troy.trade.api.model.dto.out.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 转币历史记录
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsFinanceRecord implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * accountCoinTellerId
     */
    @ApiModelProperty(value = "accountCoinTellerId")
    private Long accountCoinTellerId;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 账户id
     */
    @ApiModelProperty(value = "账户id")
    private Long accountId;
    /**
     * 账户币种id
     */
    @ApiModelProperty(value = "账户币种id")
    private Long accountCoinId;
    /**
     * 交易所code
     */
    @ApiModelProperty(value = "交易所code")
    private String exchCode;
    /**
     * 入账账户id
     */
    @ApiModelProperty(value = "入账账户id")
    private Long entryAccountId;
    /**
     * 入账账户币种id
     */
    @ApiModelProperty(value = "入账账户币种id")
    private Long entryAccountCoinId;
    /**
     * 入账交易所code
     */
    @ApiModelProperty(value = "入账交易所code")
    private String entryExchCode;
    /**
     * 交易所币种id
     */
    @ApiModelProperty(value = "交易所币种id")
    private String exchangeCoinId;
    /**
     * 币种名称
     */
    @ApiModelProperty(value = "币种名称")
    private String coinName;
    /**
     * 链名称
     */
    @ApiModelProperty(value = "链名称")
    private String chainName;
    /**
     * 操作类型(1充币 2提币 3转币)
     */
    @ApiModelProperty(value = "操作类型(1充币 2提币 3转币)")
    private Integer operType;
    /**
     * 交易数量
     */
    @ApiModelProperty(value = "交易数量")
    private java.math.BigDecimal businessAmount;
    /**
     * 到账数量
     */
    @ApiModelProperty(value = "到账数量")
    private java.math.BigDecimal actualAmount;
    /**
     * 手续费
     */
    @ApiModelProperty(value = "手续费")
    private java.math.BigDecimal fee;
    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号")
    private String txid;
    /**
     * 区块高度
     */
    @ApiModelProperty(value = "区块高度")
    private Integer blockHeight;
    /**
     * 节点确认数
     */
    @ApiModelProperty(value = "节点确认数")
    private Integer confirmations;
    /**
     * 充币地址
     */
    @ApiModelProperty(value = "充币地址")
    private String addr;
    /**
     * 源地址
     */
    @ApiModelProperty(value = "源地址")
    private String sourceAddress;
    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private java.util.Date applyTime;
    /**
     * 状态
     * {充币 1待确认 2确认中 3可交易 4成功 5失败},
     * {提币 11审核中 12提币中 13成功 14审核拒绝 15失败},
     * {转币 21转币中 22成功 23失败}
     */
    @ApiModelProperty(value = "状态({充币 1待确认 2确认中 3可交易 4成功 5失败}, {提币 11审核中 12提币中 13成功 14审核拒绝 15失败}, {转币 21转币中 22成功 23失败})")
    private Integer status;
    /**
     * 目标交易所余额是否充足(0不充足 1充足)
     */
    @ApiModelProperty(value = "目标交易所余额是否充足(0不充足 1充足)")
    private Integer enoughAmount;
    /**
     * 完成时间
     */
    @ApiModelProperty(value = "完成时间")
    private java.util.Date finishTime;
    /**
     * 企业钱包充币唯一码
     */
    @ApiModelProperty(value = "企业钱包充币唯一码")
    private String guid;
    /**
     * 外部充币唯一码
     */
    @ApiModelProperty(value = "外部充币唯一码")
    private String outGuid;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    private String approver;
    /**
     * 审批时间
     */
    @ApiModelProperty(value = "审批时间")
    private Date approveTime;

    /**
     * 创建者
     */
    protected String createBy;

    /**
     * 创建日期
     */
    protected Date createTime;

    /**
     * 更新者
     */
    protected String updateBy;

    /**
     * 更新日期
     */
    protected Date updateTime;

    /**
     * 最后修改人IP
     */
    protected String lastUpdateFromIp;

    private String accountNameEn;

}

