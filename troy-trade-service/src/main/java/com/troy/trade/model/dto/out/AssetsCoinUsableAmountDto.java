package com.troy.trade.model.dto.out;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 资产账户币种可用余额
 *
 * @author zhangchengjie
 * @date 2019/08/22
 */
@Setter
@Getter
public class AssetsCoinUsableAmountDto implements Serializable {

    private static final long serialVersionUID = 2996294331542350161L;

    /**
     * 总额
     */
    private BigDecimal totalAmount;

    /**
     * 可用额
     */
    private BigDecimal usableAmount;

    /**
     * 冻结额
     */
    private BigDecimal frozenAmount;

    /**
     * 币种名称
     */
    private String coinName;

}
