package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqPage;
import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class BtwBalanceRecordsReqData extends ReqPage {

    private Long id;

    private String coinName;

    private Date createTime;

    private Date endTime;
}
