package com.troy.trade.api.model.dto.out.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCoinResDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 充币地址
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsCoinInfoResData extends ResData {

    @ApiModelProperty(value = "账户币种id")
    private Long accountCoinId;

    @ApiModelProperty(value = "充币地址")
    private String chargeAddr;

    @ApiModelProperty(value = "充币状态查询url")
    private String chargeStatusUrl;

    /**
     * EOS充币地址标签
     * 因为获取充币地址时BTW限制unid为EOS标签
     * unid为account_coin_id-account_id拼接，这个属于业务限制，
     * 所以充币地址标签只好是unid了
     */
    @ApiModelProperty(value = "eos充币地址名称")
    private String eosAddrName;

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "可用额")
    private BigDecimal usableAmount;

    @ApiModelProperty(value = "冻结额")
    private BigDecimal frozenAmount;

    @ApiModelProperty(value = "手续费比率")
    private BigDecimal feeRate;

    @ApiModelProperty(value = "最小提现数量")
    private BigDecimal withdrawsLeast;

    @ApiModelProperty(value = "提现手续费")
    private BigDecimal withdrawsFee;

    @ApiModelProperty(value = "转币手续费")
    private BigDecimal transferCoinFee;

    @ApiModelProperty(value = "历史提现地址数组")
    private List<String> historyAddrs;

    @ApiModelProperty(value = "USDT币种（链-地址映射）")
    private Map<String, String> usdtAddrMap;

    @ApiModelProperty(value = "USDT链名称集合")
    private Set<String> usdtChainNames;

    @ApiModelProperty(value = "提币手续费收取方式：1-按量、2-按比例")
    private Integer withdrawsFeeType;

    /**
     * 交易所币种名称, 用于区分是否是EOS币
     */
    @JsonIgnore
    private String exchCoinName;

    /**
     * 交易所code exchCode
     */
    @JsonIgnore
    private String exchCode;

    /**
     * 未认证，单笔提现最大额度
     */
    @JsonIgnore
    private BigDecimal maxTimeWidwalUnverf;
    /**
     * 未认证，单日提现最大额度
     */
    @JsonIgnore
    private BigDecimal maxDayWidwalUnverf;
    /**
     * 已认证，单笔提现最大额度
     */
    @JsonIgnore
    private BigDecimal maxTimeWidwalVerf;
    /**
     * 已认证，单日提现最大额度
     */
    @JsonIgnore
    private BigDecimal maxDayWidwalVerf;

    @ApiModelProperty(value = "单次限额")
    private BigDecimal maxTimeWidwal;

    @ApiModelProperty(value = "单日限额")
    private BigDecimal dayWidwal;

    @ApiModelProperty(value = "最小转币数量")
    private BigDecimal transferLeast;
    /**
     * chinese 备注
     */
    private String chinese;

    /**
     * english备注
     */
    private String english;

    /**
     * 币种充币中文描述
     */
    private String depositChinese;
    /**
     * 币种充币英文描述
     */
    private String depositEnglish;
    /**
     * 币种转币中文描述
     */
    private String turnChinese;
    /**
     * 币种转币英文描述
     */
    private String turnEnglish;

    private Integer showPrecision;

    private String coinName;

    @ApiModelProperty(value = "omni")
    private Map<String, Object> omniExchangeCoin;

    @ApiModelProperty(value = "erc20")
    private Map<String, Object> erc20ExchangeCoin;

}

