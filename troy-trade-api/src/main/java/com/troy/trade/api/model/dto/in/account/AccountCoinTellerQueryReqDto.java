package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.in.ReqPage;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户充币记录查询DTO
 *
 * @author caq
 */
@Setter
@Getter
public class AccountCoinTellerQueryReqDto extends ReqPage {

    /**
     * accountCoinTellerId
     */
    private Long accountCoinTellerId;

    /**
     * 提现申请表id
     */
//    private Long accountCoinApplyId;

    /**
     * 用户ID
     */
    private Long userId;

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
     * 交易所code
     */
    private String exchCode;

    /**
     * 交易所币种id
     */
    private String exchangeCoinId;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 转入交易所
     */
    private String entryExchCode;

    /**
     * 入账账户
     */
    private Long entryAccountId;

    /**
     * 操作类型(1充币 2提币)
     */
    private Integer operType;

    /**
     * 交易金额
     */
    private BigDecimal businessAmount;

    /**
     * 实际到账数量
     */
    private BigDecimal actualAmount;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 交易号
     */
    private String txid;

    /**
     * 区块高度
     */
    private Integer blockHeight;

    /**
     * 节点确认数
     */
    private Integer confirmations;

    /**
     * 充币地址
     */
    private String addr;

    /**
     * 源地址
     */
    private String sourceAddress;

    /**
     * 状态状态（充币：1待确认；2确认中；3成功；4失败；   提币：10等待；11处理中；12成功；13失败；14撤销；）
     */
    private Integer status;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 企业钱包充币唯一码
     */
    private String guid;

    /**
     * 企业钱包充币唯一码
     */
    private String outGuid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间从
     */
    private Date beginTime;

    /**
     * 创建时间到
     */
    private Date endTime;

    /**
     * 处理开始时间
     */
    private Date endFinishTime;

    /**
     * 处理截止时间
     */
    private Date beginFinishTime;


}
