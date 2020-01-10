package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.constant.account.AccountOwnership;
import lombok.Getter;
import lombok.Setter;

/**
 * 火币账户ID修改出参
 * @author yanping
 */
@Setter
@Getter
public class UpdateAcctIdResDto extends ResData {

    private boolean result;

    public UpdateAcctIdResDto() {
        super();
    }

    public UpdateAcctIdResDto(boolean result) {
        this.result = result;
    }

    public static UpdateAcctIdResDto getInstance(boolean result){
        UpdateAcctIdResDto accountTypeReqDto = new UpdateAcctIdResDto(result);
        return accountTypeReqDto;
    }
}
