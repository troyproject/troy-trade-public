package com.troy.trade.model.dto.out;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户下单限制
 *
 * @author dp
 */
@Setter
@Getter
public class SpotTransLimitResDto extends ResData {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 交易所CODE
     */
    private String exchCode;

    /**
     * 当前挂单条数
     */
    private Integer countNum;
}
