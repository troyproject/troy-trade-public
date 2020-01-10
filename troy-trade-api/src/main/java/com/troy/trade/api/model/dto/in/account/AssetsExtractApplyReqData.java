package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsExtractApplyReqData extends ReqData {

    @ApiModelProperty(value = "账户币种id")
    private Long accountCoinId;

    @ApiModelProperty(value = "交易所币种id")
    private Long accountId;

    @ApiModelProperty(value = "提现金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "提现地址")
    private String addr;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否保存地址 （0不保存 1保存）")
    private Integer saveAddr;

    @ApiModelProperty(value = "链名称")
    private String chainName;

    @ApiModelProperty(value = "eos")
    private String eosAddrName;

    /**
     * 谷歌验证码
     */
    @ApiModelProperty(value = "谷歌验证码")
    private String googleVerificationCode;

    /**
     * 短信验证码
     */
    @ApiModelProperty(value = "短信验证码")
    private String smsVerificationCode;

    /**
     * 验邮箱证码
     */
    @ApiModelProperty(value = "验邮箱证码")
    private String emailVerificationCode;

    @JsonIgnore
    private Long userId;

    @JsonIgnore
    private String lastUpdateFromIp;
}
