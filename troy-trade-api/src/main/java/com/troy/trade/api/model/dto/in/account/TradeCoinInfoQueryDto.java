package com.troy.trade.api.model.dto.in.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhangchengjie
 * @date 2019/08/29
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TradeCoinInfoQueryDto extends ReqData implements Serializable {
    /**
     * 账户id
     */
    @ApiModelProperty("账户id")
    private Long accountId;
    /**
     * base币种id
     */
    private String baseExchangeCoinId;
    /**
     * quote币种id
     */
    private String quoteExchangeCoinId;

    @ApiModelProperty("交易所code")
    private String exchCode;

    @ApiModelProperty("base币种名称")
    private String baseCoinName;

    @ApiModelProperty("quote币种名称")
    private String quoteCoinName;

    public TradeCoinInfoQueryDto(Long accountId, String baseExchangeCoinId, String quoteExchangeCoinId, Long userId) {
        this.accountId = accountId;
        this.baseExchangeCoinId = baseExchangeCoinId;
        this.quoteExchangeCoinId = quoteExchangeCoinId;
        this.userId = userId;
    }

    @JsonIgnore
    private Long userId;

    private Integer accountOwnership;

}
