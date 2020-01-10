package com.troy.trade.service.impl;

import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.trade.api.model.dto.in.exchange.ExchangeCodeReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeSymbolListResDto;
import com.troy.trade.service.IExchangeSymbolService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ExchangeSymbolServiceImplTest {

    @Autowired
    IExchangeSymbolService exchangeSymbolService;

    @Test
    public void getExchangeSymbolList() {
        ExchangeCodeReqDto exchangeCodeReqDto = new ExchangeCodeReqDto();
        exchangeCodeReqDto.setExchCode(ExchangeCode.HUOBI.code());
        ExchangeSymbolListResDto exchangeSymbolListResDto = exchangeSymbolService.getExchangeSymbolList(exchangeCodeReqDto);
        System.out.println("----");
    }
}