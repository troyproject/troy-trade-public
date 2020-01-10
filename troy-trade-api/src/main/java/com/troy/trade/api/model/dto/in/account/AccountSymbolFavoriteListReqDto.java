package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountSymbolFavoriteListReqDto extends ReqData {

    private String exchCode;

    private Long userId;

    /**
     * 类型
     * 合约futures, 现货spot
     */
    private String type;

}
