package com.troy.trade.service;

import com.troy.trade.model.dto.out.WalletApplyCoinOutDto;
import com.troy.trade.service.impl.WalletServiceImpl;
import com.troy.trade.util.WalletResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
@Slf4j
public class WalletServiceTest {

    @Autowired
    private IWalletService walletService;

    @Test
    public void queryAmount() {
        WalletServiceImpl walletService = new WalletServiceImpl();
        WalletResponse<String> queryAmount = walletService.queryAmount("ETH");
        System.out.println(queryAmount);
    }

    @Test
    public void queryBillListTask() {
        WalletServiceImpl walletService = new WalletServiceImpl();
        walletService.queryBillListTask();
    }

}
