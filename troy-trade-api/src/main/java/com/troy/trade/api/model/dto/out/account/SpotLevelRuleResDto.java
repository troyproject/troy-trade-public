package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SpotLevelRuleResDto  extends ResData {

    private Long id;

    /**
     * 等级
     */
    private Integer level;
    /**
     * 交易量
     */
    private java.math.BigDecimal btcCount;

    /**
     * 交易量
     */
    private java.math.BigDecimal troyCount;

    private Date createTime;

    private String updateBy;

    private String createBy;

    private Date updateTime;

    private String lastUpdateFromIp;
}
