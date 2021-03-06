package com.troy.trade.service;

import com.troy.trade.api.model.constant.UserTradeRightEnum;
import com.troy.trade.api.model.dto.in.order.OpenOrderListReqData;
import com.troy.trade.mapper.exchange.ExchangeCoinMapper;
import com.troy.trade.model.domain.exchange.ExchangeCoinModel;
import com.troy.trade.service.impl.TaskServiceImpl;
import com.troy.trade.util.BusinessMethodsUtil;
import com.troy.trade.util.ConstantTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/23
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
@Slf4j
public class TaskServiceTest {

    @Autowired
    private TaskServiceImpl assetsService;
    @Autowired
    IOrderService orderService;
    @Autowired
    private IExchangeAccountService exchangeAccountService;
    @Autowired
    private IAccountBindService accountBindService;
    @Autowired
    IAccountSymbolFavoriteService accountSymbolFavoriteService;
    @Autowired
    ISpotTransPendingService spotTransPendingService;
    @Autowired
    ExchangeCoinMapper exchangeCoinMapper;
    @Autowired
    private BusinessMethodsUtil businessMethodsUtil;


    @Autowired
    private IAccountOverAssetsService accountOverAssetsService;
    @Test
    public void syncThirdOrderStatusJob() {
        assetsService.syncExchangeAccountThirdOrderStatus( exchangeAccountService.findById(1164074920108494853L));
        log.info(ConstantTest.LOG_LINE + "{} " + ConstantTest.LOG_LINE);
    }


    @Test
    public void syncPlatformDelFeeJob() {
        //  assetsService.syncThirdDelFeeJob(1164074920108494850L, 1);

        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, 1);
    }
    @Test
    public void queryOrder() {
        System.out.println("queryOrder=======");
        OpenOrderListReqData req = new OpenOrderListReqData();
        req.setUserAcctId(1164073804746592258L);
        req.setExchSymbolId("1111");
        req.setPageNum(0);
        req.setPageSize(5);
      //  System.out.println(orderService.queryCurrentOrder(req));
      //  System.out.println(orderService.queryComplateSucessOpenOrder(req));

        System.out.println(orderService.queryHistoryOpenOrder(req));

    }


    @Test
    public void syncTransPendToHistory() {
        spotTransPendingService.syncTransPendToHistory();
    }


    /**
     * 查询用户交易权限
     */
    @Test
    public void getUserTradeRight() {
        System.out.println("start------------------");
        System.out.println(orderService.getUserTradeRight(1L, UserTradeRightEnum.canTrade.getCode()));
        System.out.println("end------------------");

    }
    /**
     * 查询用户交易权限
     */
    @Test
    public void queryAdminHistoryOrder() {
        System.out.println("start------------------");
        accountOverAssetsService.synOverAssets();
        System.out.println("end------------------");

    }

    /**
     * 查询用户交易权限
     */
    @Test
    public void queryAdminHistoryOrder1() {
        System.out.println("start------------------");

        List<ExchangeCoinModel>list = exchangeCoinMapper.selectList();
        List<ExchangeCoinModel>list1 = new ArrayList<>();
        for (ExchangeCoinModel model : list){
            model.setExchCode("troy");
            model.setStatus(1);
            model.setExchangeCoinId("troy_"+model.getName().toLowerCase());
            model.setExchWithdrawsFee(BigDecimal.ONE);
            model.setWithdrawsLeast(BigDecimal.ONE);
            model.setWithdrawsFeeType(1);
            model.setOperationPrecision(8);
            model.setShowPrecision(8);
            model.setCreateTime(new Date());
            list1.add(model);
        }
        exchangeCoinMapper.insertBatch(list1);
        System.out.println("end------------------");

    }
}
