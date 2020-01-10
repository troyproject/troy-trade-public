package com.troy.trade.util;

import com.troy.commons.exchange.model.constant.ExchangeCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessMethodsUtilTest {

    @Autowired
    BusinessMethodsUtil businessMethodsUtil;

    @Test
    public void usdtToCny() {
    }

    @Test
    public void btcToCny() {
        BigDecimal price = businessMethodsUtil.btcToCny(ExchangeCode.OKEX);
        System.out.println(price.toPlainString());
    }

    @Test
    public void turnToBtc() {
        BigDecimal price = businessMethodsUtil.turnToBtc(ExchangeCode.OKEX,"USDT");
        System.out.println(price.toPlainString());
    }
}