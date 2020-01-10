package com.troy.trade.api.model.dto.in.spot;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 手续费等级规则
 */
@Setter
@Getter
public class ServiceFeeRuleReqDto extends ReqData {

    private Long feeRuleId;
    private String exchCode;
    private Integer level;
    private BigDecimal blockMakerRate;
    private BigDecimal blockTakerRate;
    private Date updateTime;
    private Date createTime;
    private Integer status;
}
