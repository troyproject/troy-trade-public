package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 交易所列表所有字段返回
 *
 * @author dp
 */
@Setter
@Getter
public class ExchangeFullResDto extends ResData {

    /**
     * exchId
     */
    private Long exchId;

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 交易所名称
     */
    private String exchName;

    /**
     * 交易所简称
     */
    private String aliasName;

    /**
     * 交易类型（1-限价交易、2-市价交易、3-两者都有）
     * @see com.troy.trade.api.model.constant.exchange.TradeType
     */
    private Integer tradeType;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 状态，0-关闭、1-开启
     * @see com.troy.commons.enums.StatusEnum
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 开通账户状态
     *
     * @see com.troy.trade.api.model.constant.exchange.RegisterAccountStatus
     */
    private Integer openAcctStatus;

    /**
     * 绑定账户状态
     *
     * @see com.troy.trade.api.model.constant.exchange.BindAccountStatus
     */
    private Integer bindAcctStatus;

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

    /*排序权重*/
    protected Integer sort;

}
