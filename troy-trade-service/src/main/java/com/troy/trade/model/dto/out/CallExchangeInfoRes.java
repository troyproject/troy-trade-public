package com.troy.trade.model.dto.out;

import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.commons.exchange.model.in.PrivateTradeReqData;
import com.troy.commons.utils.EnumUtils;
import com.troy.trade.api.model.dto.out.account.CallExchangeInfoNoDecodeResDto;
import com.troy.trade.service.foreign.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 调用交易所信息实体
 *
 * @author dp
 */
@Setter
@Getter
public class CallExchangeInfoRes extends CallExchangeInfoNoDecodeResDto {

    /**
     * 交易调用API
     */
    private TradeExchangeClient tradeExchangeClient;

    /**
     * 市场调用API
     */
    private MarketExchangeClient marketExchangeClient;

    /**
     * 账户调用API
     */
    private AccountExchangeClient accountExchangeClient;

    /**
     * 杠杆账户
     * @return
     */
    private AccountMarginExchangeClient accountMarginExchangeClient;


    public PrivateTradeReqData toPrivateTradeReqData(){
        PrivateTradeReqData privateTradeReqData = new PrivateTradeReqData();
        privateTradeReqData.setApiKey(this.apiKey);
        privateTradeReqData.setApiSecret(this.apiSecret);
        privateTradeReqData.setPassphrase(this.passphrase);
        privateTradeReqData.setExchCode(EnumUtils.getEnumByCode(this.exchCode, ExchangeCode.class));
        privateTradeReqData.setThirdAcctId(this.thirdAcctId);
        return privateTradeReqData;
    }


}
