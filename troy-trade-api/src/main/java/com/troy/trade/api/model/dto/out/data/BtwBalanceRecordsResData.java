package com.troy.trade.api.model.dto.out.data;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class BtwBalanceRecordsResData extends ResData {

    private Long id;

    private String coinName;
    /**
     * 剩余数量
     */
    private BigDecimal balanceAmount;

    private Date createTime;
}
