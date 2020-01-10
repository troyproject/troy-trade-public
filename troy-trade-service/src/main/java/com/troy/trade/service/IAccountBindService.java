package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.AccountBindBalanceReqData;
import com.troy.trade.api.model.dto.in.account.AccountBindExchReqData;
import com.troy.trade.api.model.dto.in.account.AccountBindIdReqDto;
import com.troy.trade.api.model.dto.in.account.AccountUnbindReqData;
import com.troy.trade.api.model.dto.out.account.AccountBalanceResDto;
import com.troy.trade.api.model.dto.out.account.AccountSpotBalanceResDto;
import com.troy.trade.api.model.dto.out.account.assets.MarginBalanceResDto;
import com.troy.trade.api.model.dto.out.exchange.AccountBindInfoResDto;
import com.troy.trade.model.domain.account.AccountBindModel;

import java.util.List;

/**
 * 账户绑定服务
 * @author troy
 */
public interface IAccountBindService extends IBaseService<AccountBindModel> {

    /**
     * 根据账户类型查找账户绑定信息
     * @param accountBindIdReqDto
     * @return
     */
    Res<ResList<AccountBindInfoResDto>> getBindInfosByBindIds(AccountBindIdReqDto accountBindIdReqDto);


    int accoutBindWithExch(AccountBindExchReqData accountBindExchReqData);


    int unBindAccount(AccountUnbindReqData accountUnbindReqData);

    Res<ResList<AccountBindInfoResDto>> list();

    Res<AccountBindInfoResDto> getBindInfos(Long accountBindId);

    Res<AccountSpotBalanceResDto> getBalanceOfExchange(AccountBindBalanceReqData accountBindBalanceReqData);

    Res<ResList<MarginBalanceResDto>> getMarginBalance(AccountBindBalanceReqData accountBindBalanceReqData);

}
