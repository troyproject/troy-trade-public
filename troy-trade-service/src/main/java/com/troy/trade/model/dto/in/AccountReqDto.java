package com.troy.trade.model.dto.in;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 账户信息列表查询参数实体
 */
@Getter
@Setter
public class AccountReqDto extends ReqData {

    /**
     * 交易所code
     */
    private String exchCode;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * @see com.troy.trade.api.model.constant.account.AccountTypeEnum
     */
    private List<Integer> accountTypes;

    /**
     * @see com.troy.trade.api.model.constant.account.PlatformEnum
     */
    private List<Integer> platforms;

}
