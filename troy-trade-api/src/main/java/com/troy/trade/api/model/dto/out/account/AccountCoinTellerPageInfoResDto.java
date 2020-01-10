package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import com.troy.commons.dto.out.ResPage;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户充值提币记录
 *
 * @author caq
 */
@Setter
@Getter
public class AccountCoinTellerPageInfoResDto extends ResData {

    /**
     * 订单数据
     */
    private List<AccountCoinTellerResDto> exchangeSymbols;
    /**
     * 总数量
     */
    private long total;

}
