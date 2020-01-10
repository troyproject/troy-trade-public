package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsCoinInfoReqData extends ReqData {

    /** 操作类型 1充币 2提币 3转币 */
    public static final int OPER_TYPE_1 = 1;

    /** 操作类型 1充币 2提币 3转币 */
    public static final int OPER_TYPE_2 = 2;

    /** 操作类型 1充币 2提币 3转币 */
    public static final int OPER_TYPE_3 = 3;

    /**
     * 操作类型 1充币 2提币 3转币
     */
    @ApiModelProperty(value = "操作类型 1充币 2提币 3转币")
    private Integer operType;

    @ApiModelProperty(value = "账户id")
    private Long accountId;

    @ApiModelProperty(value = "交易所币种id")
    private String exchangeCoinId;

    @ApiModelProperty(value = "USDT链名称，（生成充币地址时需要改参数）")
    private String usdtChainName;

    @JsonIgnore
    private Long userId;

    @JsonIgnore
    private String lastUpdateFromIp;
}
