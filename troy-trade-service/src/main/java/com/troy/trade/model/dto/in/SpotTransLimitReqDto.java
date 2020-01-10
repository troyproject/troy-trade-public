package com.troy.trade.model.dto.in;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询用户当前挂单数入参
 *
 * @author dp
 */
@Setter
@Getter
public class SpotTransLimitReqDto extends ReqData {

    private Long userId;

    private String exchCode;
}
