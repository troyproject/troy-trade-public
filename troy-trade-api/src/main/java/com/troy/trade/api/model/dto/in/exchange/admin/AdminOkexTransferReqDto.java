package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import java.math.BigDecimal;

@Setter
@Getter
public class AdminOkexTransferReqDto extends ReqData {

    /**
     * 币种名称
     */
    @NotBlank(message = "币种名称不能为空")
    private String coinName;

    /**
     * 划转数量
     */
    private BigDecimal amount;

    /**
     * 转出账户
     * okex:
     *   0:子账户
     1:币币
     3:合约
     4:C2C
     5:币币杠杆
     6:资金账户
     8:余币宝
     9:永续合约
     */
    private String from;

    /**
     * 转入账户
     * okex:
     *   0:子账户
     1:币币
     3:合约
     4:C2C
     5:币币杠杆
     6:资金账户
     8:余币宝
     9:永续合约
     */
    private String to;

    /**
     * 交易所账户主键ID
     */
    private Long exchAcctId;

}
