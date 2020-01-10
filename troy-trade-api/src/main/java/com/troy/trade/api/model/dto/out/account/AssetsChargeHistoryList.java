package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 充币历史
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsChargeHistoryList extends ResData {
    @ApiModelProperty(value = "充提历史id")
    private Long accountCoinRechargeId;
    @ApiModelProperty(value = "状态状态（充币：1待确认；2确认中；3成功；4失败； 提币：10等待；11处理中；12成功；13失败；14撤销；）")
    private Integer status;
    @ApiModelProperty(value = "币种名称")
    private String coinName;
    @ApiModelProperty(value = "币种名称")
    private String chainName;
    @ApiModelProperty(value = "交易数量")
    private BigDecimal businessAmount;
    @ApiModelProperty(value = "实际到账数量")
    private BigDecimal amountActual;
    @ApiModelProperty(value = "充提币地址")
    private String addr;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "完成时间")
    private Date finishTime;
}

