package com.troy.trade.service;

import com.troy.trade.api.model.dto.in.account.AccountIdReqDto;
import com.troy.trade.api.model.dto.out.account.CallExchangeInfoAccountResDto;

/**
 * 查询交易所账户信息--未解密
 */
public interface ICallExchangeInfoService {

    /**
     * 获取未解密的账户信息
     * @param accountIdReqDto
     * @return
     */
    CallExchangeInfoAccountResDto callExchangeInfo(AccountIdReqDto accountIdReqDto);
}
