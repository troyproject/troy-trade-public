package com.troy.trade.model.dto.out;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

/**
 * 账户信息列表查询参数实体
 */
@Getter
@Setter
public class AccountBindIdResDto extends ReqData {

    /**
     * 用户ID
     */
    private Long accountBindId;

}
