package com.troy.trade.api.model.dto.in.spot;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 等级配置
 */
@Setter
@Getter
public class SpotLevelRuleReqDto extends ReqData {

    private Integer level;

    private BigDecimal btcCount;
    private Date createTime;
    private String createBy;
    private BigDecimal troyCount;

}
