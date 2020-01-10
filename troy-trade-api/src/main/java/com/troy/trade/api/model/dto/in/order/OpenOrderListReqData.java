package com.troy.trade.api.model.dto.in.order;

import com.troy.trade.api.model.dto.in.AuthReqData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Han
 */
@Setter
@Getter
public class OpenOrderListReqData extends AuthReqData {

    private static final long serialVersionUID = 2996290231512350161L;

    private Long userAcctId;



    private String exchSymbolId;

    private String symbol;

    private String exchCode;

    private Integer limit;

    private Long userId;

    private Integer side;

    /**
     * 0 统一账户' : 1 '绑定账户'
     */
    private Integer accountType;

    private Date startTime;
    private Date endTime;


    // 1完全成交 2 历史挂单
    private Integer queryType;
}
