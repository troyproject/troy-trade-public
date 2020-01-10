package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import com.troy.trade.api.model.constant.account.AccountOwnership;
import lombok.Getter;
import lombok.Setter;

/**
 * 火币账户ID修改入参
 * @author yanping
 */
@Setter
@Getter
public class UpdateAcctIdReqDto extends ReqData {

    private static final long serialVersionUID = 2996290991542350061L;
    private AccountOwnership accountOwnership;
    private Long dbId;
    private String thirdAcctId;

    public UpdateAcctIdReqDto() {
        super();
    }

    public UpdateAcctIdReqDto(AccountOwnership accountOwnership, Long dbId, String thirdAcctId) {
        this.accountOwnership = accountOwnership;
        this.dbId = dbId;
        this.thirdAcctId = thirdAcctId;
    }

    public static UpdateAcctIdReqDto getInstance(AccountOwnership accountOwnership, Long dbId, String thirdAcctId){
        UpdateAcctIdReqDto accountTypeReqDto = new UpdateAcctIdReqDto( accountOwnership, dbId, thirdAcctId);
        return accountTypeReqDto;
    }
}
