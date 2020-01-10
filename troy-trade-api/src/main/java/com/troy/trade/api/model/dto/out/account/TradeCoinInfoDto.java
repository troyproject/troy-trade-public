package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhangchengjie
 * @date 2019/08/29
 */
@Setter
@Getter
public class TradeCoinInfoDto extends ResData implements Serializable {

    /**
     * 账户base币种
     */
    private TradeCoinDto baseTradeCoin;

    /**
     * 账户quote币种
     */
    private TradeCoinDto quoteTradeCoin;

}
