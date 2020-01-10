package com.troy.trade.service.impl.order;

import com.alibaba.fastjson.JSONObject;
import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.in.ReqFactory;
import com.troy.redis.RedisUtil;
import com.troy.redis.lock.DistributedLockHandler;
import com.troy.trade.api.model.constant.order.TradeOrderConstant;
import com.troy.trade.api.model.dto.in.order.CancelSpotOrderReqDto;
import com.troy.trade.api.model.dto.in.order.CreateSpotOrderReqDto;
import com.troy.trade.service.IOrderService;
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
public class OrderServiceImplTest {

    @Autowired
    IOrderService orderService;

    @Test
    public void createSpotOrder() {
        CreateSpotOrderReqDto createSpotOrderReqDto = new CreateSpotOrderReqDto();
        // 火币
        createSpotOrderReqDto.setUserId(1161841206590857217L);
        createSpotOrderReqDto.setAccountId(1164073804746592258L);
        createSpotOrderReqDto.setAmount(new BigDecimal(5));
        createSpotOrderReqDto.setPrice(new BigDecimal("0.014939"));
        createSpotOrderReqDto.setExchCode("huobi");
        createSpotOrderReqDto.setMarketCashAmount(null);
        createSpotOrderReqDto.setOrderSide(1);
        createSpotOrderReqDto.setOrderType(1);
        createSpotOrderReqDto.setSource(1);
        createSpotOrderReqDto.setSymbol("TRX/USDT");
        createSpotOrderReqDto.setExchSymbolId("1111");
        // 币安
       /* createSpotOrderReqDto.setUserId(1161841206590857217L);
        createSpotOrderReqDto.setAccountId(1164074920108494850L);
        createSpotOrderReqDto.setAmount(new BigDecimal(154));
        createSpotOrderReqDto.setPrice(new BigDecimal("0.00006702"));
        createSpotOrderReqDto.setExchCode("binance");
        createSpotOrderReqDto.setMarketCashAmount(null);
        createSpotOrderReqDto.setOrderSide(2);
        createSpotOrderReqDto.setOrderType(1);
        createSpotOrderReqDto.setSource(1);
        createSpotOrderReqDto.setSymbol("QKC/ETH");
        createSpotOrderReqDto.setExchSymbolId("2222");*/
        // gateio
//        createSpotOrderReqDto.setUserId(1161841206590857217L);
//        createSpotOrderReqDto.setAccountId(1164090268778106882L);
//        createSpotOrderReqDto.setAmount(new BigDecimal("4546"));
//        createSpotOrderReqDto.setPrice(new BigDecimal("0.000220"));
//        createSpotOrderReqDto.setExchCode("gateio");
//        createSpotOrderReqDto.setMarketCashAmount(null);
//        createSpotOrderReqDto.setOrderSide(2);
//        createSpotOrderReqDto.setOrderType(1);
//        createSpotOrderReqDto.setSource(1);
//        createSpotOrderReqDto.setSymbol("GSE/USDT");
//        createSpotOrderReqDto.setExchSymbolId("3333");
        // okex
//        createSpotOrderReqDto.setUserId(1161841206590857217L);
//        createSpotOrderReqDto.setAccountId(1164090268778106883L);
//        createSpotOrderReqDto.setAmount(new BigDecimal("190.114"));
//        createSpotOrderReqDto.setPrice(new BigDecimal(0.00526));
//        createSpotOrderReqDto.setExchCode("okex");
//        createSpotOrderReqDto.setMarketCashAmount(null);
//        createSpotOrderReqDto.setOrderSide(1);
//        createSpotOrderReqDto.setOrderType(1);
//        createSpotOrderReqDto.setSource(1);
//        createSpotOrderReqDto.setSymbol("TRX/USDT");
//        createSpotOrderReqDto.setExchSymbolId("4444");

        // bitfinex
//        createSpotOrderReqDto.setUserId(1161841206590857217L);
//        createSpotOrderReqDto.setAccountId(1164093362681286657L);
//        createSpotOrderReqDto.setAmount(new BigDecimal(200));
//        createSpotOrderReqDto.setPrice(new BigDecimal("0.015499"));
//        createSpotOrderReqDto.setExchCode("bitfinex");
//        createSpotOrderReqDto.setMarketCashAmount(null);
//        createSpotOrderReqDto.setOrderSide(1);
//        createSpotOrderReqDto.setOrderType(1);
//        createSpotOrderReqDto.setSource(1);
//        createSpotOrderReqDto.setSymbol("TRX/USD");
//        createSpotOrderReqDto.setExchSymbolId("5555");

        Req<CreateSpotOrderReqDto> createSpotOrderReqDtoReq = ReqFactory.getInstance().createReq(createSpotOrderReqDto);
        System.out.println(JSONObject.toJSONString(createSpotOrderReqDtoReq));
       System.out.println("服务执行结果：" + orderService.createSpotOrder(createSpotOrderReqDto));
    }

    @Test
    public void cancelSpotOrder() {
        CancelSpotOrderReqDto cancelSpotOrderReqDto = new CancelSpotOrderReqDto();
        cancelSpotOrderReqDto.setUserId(1161841206590857217L);
        cancelSpotOrderReqDto.setCancelType(TradeOrderConstant.CancelType.SINGLE);

        cancelSpotOrderReqDto.setAccountId(1164073804746592258L);
        cancelSpotOrderReqDto.setSpotTransId(0L);
        cancelSpotOrderReqDto.setExchSymbolId("374db090fcfb48899181d892911608e4");
        cancelSpotOrderReqDto.setSource(1);
        cancelSpotOrderReqDto.setOrderId("47613256922");
        cancelSpotOrderReqDto.setSpotTransId(1171337656562278402L);


        // 火币
        System.out.println("服务执行结果：" + orderService.cancelSpotOrder(cancelSpotOrderReqDto));
    }

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    DistributedLockHandler distributedLockHandler;

    @Test
    public void testLock(){
        Long accountCoinId = 1164090268778106882L;
        BigDecimal amount = new BigDecimal("");
//        Lock lock = new Lock(accountCoinId, );
    }


}
