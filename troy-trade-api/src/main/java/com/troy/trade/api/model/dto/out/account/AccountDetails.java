package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Han
 */
@Setter
@Getter
public class AccountDetails extends ResData implements Comparable {

    private static final long serialVersionUID = 299629099151223161L;

    private Long accountId;
    private String exchangeCode;
    private String exchangeParentCode;
    private Integer accountType;
    private String accountName;
    private Integer platform;
    private Date createTime;
    private BigDecimal btcAmount;
    private String exchangeName;
    // 账户类型
    private Integer type;
    private String accountNameEn;

    private List<AccountRiskDetails> list;

    @Override
    public int compareTo(Object o) {
        if (o instanceof AccountDetails) {
            AccountDetails comparableAccountDetails = (AccountDetails) o;
            if (this.btcAmount != null
                    && comparableAccountDetails.getBtcAmount() != null
                    && this.platform != null && comparableAccountDetails.getPlatform() != null) {
                int platFormComparable = this.platform.compareTo(comparableAccountDetails.getPlatform());
                if (platFormComparable == 0) {
                    return comparableAccountDetails.getBtcAmount().compareTo(this.btcAmount);
                } else {
                    return platFormComparable;
                }
            }
        }
        return 0;
    }
}
