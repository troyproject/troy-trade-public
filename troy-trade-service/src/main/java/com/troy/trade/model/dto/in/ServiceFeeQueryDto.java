package com.troy.trade.model.dto.in;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhangchengjie
 * @date 2019/08/29
 */
@Setter
@Getter
public class ServiceFeeQueryDto implements Serializable {
    /**
     * 账户id
     */
    private Long accountId;
    @JsonIgnore
    private Long userId;
}
