package com.troy.trade.service.impl;

import com.troy.commons.exchange.model.constant.ExchangeCode;
import com.troy.commons.utils.ApplicationContextUtil;
import com.troy.trade.model.dto.in.exchange.ExchAcctDeptWdralReqDto;
import com.troy.trade.service.IExchAcctDeptWdralService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ExchAcctDeptWdralServiceImplTest {

    @Test
    public void queryExchAcctDeptWdralInfo() {
        IExchAcctDeptWdralService exchAcctDeptWdralService = ApplicationContextUtil.getBean(IExchAcctDeptWdralService.class);
        ExchAcctDeptWdralReqDto exchAcctDeptWdralReqDto = new ExchAcctDeptWdralReqDto();
        exchAcctDeptWdralReqDto.setApplyTime(new Date().getTime());
        exchAcctDeptWdralReqDto.setExchCode(ExchangeCode.GATEIO);
        exchAcctDeptWdralReqDto.setExchAcctId(1164074920108494852L);
        exchAcctDeptWdralReqDto.setTxId("0x518012fc1c7c60bba379ea397aca0c54ac3e44b63abf2b7b3695d3e8acd38e57");
        exchAcctDeptWdralReqDto.setCoinName("ETH");
        exchAcctDeptWdralReqDto.setDeptWdralType(2);
        exchAcctDeptWdralService.queryExchAcctDeptWdralInfo(exchAcctDeptWdralReqDto);
    }
}