package com.troy.trade.model.dto.in;

import lombok.*;

import java.io.Serializable;

/**
 * 查询资产账户币种可用余额Dto
 *
 * @author zhangchengjie
 * @date 2019/08/22
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QueryAssetsCoinAmountDto implements Serializable {

    private static final long serialVersionUID = 2996294331542350161L;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 交易所币种id
     */
    private String exchangeCoinId;

}
