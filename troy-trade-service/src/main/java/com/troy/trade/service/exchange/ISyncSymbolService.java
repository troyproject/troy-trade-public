package com.troy.trade.service.exchange;

import com.troy.trade.api.model.dto.in.exchange.ExchangeCodeReqDto;

/**
 * @author yanping
 */
public interface ISyncSymbolService {

    /**
     * 根据参数同步交易对及币种信息
     * @param exchangeCodeReqDto
     */
    void syncSymbolCoin(ExchangeCodeReqDto exchangeCodeReqDto);
}
