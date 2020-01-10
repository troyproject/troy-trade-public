package com.troy.trade.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.in.ReqFactory;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchAcctWithdrawReqDto;
import com.troy.trade.model.dto.in.BalanceOfExchangeReq;
import com.troy.trade.model.dto.in.CallExchangeInfoReq;
import com.troy.trade.service.IExchangeAccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ExchangeAccountServiceImplTest {

    @Autowired
    IExchangeAccountService exchangeAccountService;

    @Test
    public void getCallExchangeInfo() {
        CallExchangeInfoReq callExchangeInfoReq = new CallExchangeInfoReq();
//        callExchangeInfoReq.setAcctBindId(111L);
        callExchangeInfoReq.setExchAcctId(1164074920108494850L);// binance
        callExchangeInfoReq.setExchAcctId(1164074920108494851L);// 火币
        System.out.println(JSONObject.toJSONString(exchangeAccountService.getCallExchangeInfo(callExchangeInfoReq)));
    }


    @Test
    public void balanceOfExchange() {
        System.out.println(JSONObject.toJSONString(exchangeAccountService.balanceOfExchange(new BalanceOfExchangeReq(1164074920108494850L, null))));
        System.out.println(JSONObject.toJSONString(exchangeAccountService.balanceOfExchange(new BalanceOfExchangeReq(1164074920108494851L, null))));
        System.out.println(JSONObject.toJSONString(exchangeAccountService.balanceOfExchange(new BalanceOfExchangeReq(1164074920108494852L, null))));
        System.out.println(JSONObject.toJSONString(exchangeAccountService.balanceOfExchange(new BalanceOfExchangeReq(1164074920108494853L, null))));
        System.out.println(JSONObject.toJSONString(exchangeAccountService.balanceOfExchange(new BalanceOfExchangeReq(1164074920108494854L, null))));
    }

    public void withdraw(){
        AdminExchAcctWithdrawReqDto adminExchAcctWithdrawReqDto = new AdminExchAcctWithdrawReqDto();
        adminExchAcctWithdrawReqDto.setCoinName("TRX");
        adminExchAcctWithdrawReqDto.setExchAcctId(1164074920108494851L);
        adminExchAcctWithdrawReqDto.setReceivedAmount(new BigDecimal("50"));//火币、okex用这个字段提
        adminExchAcctWithdrawReqDto.setTotalAmount(new BigDecimal("51"));//币安用这个字段提

        Req<AdminExchAcctWithdrawReqDto> adminExchAcctWithdrawReqDtoReq = ReqFactory.getInstance().createReq(adminExchAcctWithdrawReqDto);
                exchangeAccountService.withdraw(adminExchAcctWithdrawReqDtoReq);
    }


}