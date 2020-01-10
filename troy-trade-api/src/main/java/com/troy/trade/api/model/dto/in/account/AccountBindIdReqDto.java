package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 账户绑定ID查询入参
 * @author yanping
 */
@Setter
@Getter
public class AccountBindIdReqDto extends ReqData {

    private static final long serialVersionUID = 2996290991542350161L;

    private Long accountBindId;
    /**
     * 账户绑定ID
     */
    private List<Long> accountBindIds;

    /**
     * 账户类型
     */
    private Integer accountType;

    public AccountBindIdReqDto() {
        super();
    }

    public AccountBindIdReqDto(List<Long> accountBindIds, Integer accountType) {
        this.accountBindIds = accountBindIds;
        this.accountType = accountType;
    }

    public static AccountBindIdReqDto getInstance(List<Long> accountBindIds, Integer accountType){
        AccountBindIdReqDto accountTypeReqDto = new AccountBindIdReqDto(accountBindIds,accountType);
        return accountTypeReqDto;
    }
}
