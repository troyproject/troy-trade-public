package com.troy.trade.service;

import com.troy.trade.api.model.dto.out.account.assets.AccountAssetsResData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangchengjie
 * @date 2019/08/23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testGetAssetsDetails() throws Exception {
        AccountAssetsResData resData = this.accountService.getAssetsDetails(1161841206590857217L);
        System.out.println(resData);
    }

}