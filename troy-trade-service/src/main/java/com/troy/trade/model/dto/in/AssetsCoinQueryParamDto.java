package com.troy.trade.model.dto.in;

import lombok.*;

import java.io.Serializable;

/**
 * @author zhangchengjie
 * @date 2019/08/27
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AssetsCoinQueryParamDto implements Serializable {

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 交易所币种id
     */
    private String exchangeCoinId;

    /**
     * 交易所币种名称
     */
    private String coinName;

}
