package com.troy.trade.mapper;

import com.alibaba.fastjson.JSON;
import com.troy.commons.utils.IdWorker;
import com.troy.trade.api.model.dto.in.account.AssetsCoinInfoReqData;
import com.troy.trade.api.model.dto.out.account.AssetsAccountCoinDto;
import com.troy.trade.api.model.dto.out.account.AssetsCoinInfoResData;
import com.troy.trade.mapper.account.AccountCoinMapper;
import com.troy.trade.model.domain.account.AccountCoinModel;
import com.troy.trade.model.dto.in.AssetsCoinQueryParamDto;
import com.troy.trade.model.dto.in.QueryAssetsCoinAmountDto;
import com.troy.trade.model.dto.out.AssetsCoinUsableAmountDto;
import com.troy.trade.util.ConstantTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AccountCoinMapperTest {

    @Autowired
    private AccountCoinMapper accountCoinMapper;

    @Test
    public void getByIdTest() {
        Long accountId = 1L;
        Long accountCoinId = 1L;
        AccountCoinModel accountCoin = accountCoinMapper.getById(accountId, accountCoinId);
        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(accountCoin));
    }

    @Test
    public void insertAccountCoinTest() {
        AccountCoinModel accountCoin = new AccountCoinModel();
        accountCoin.setAccountCoinId(IdWorker.getId());
        accountCoin.setAccountId(3L);
        accountCoin.setUserId(1L);
        accountCoin.setExchCode("huobi");
        accountCoin.setExchangeCoinId("1");
        accountCoin.setCoinName("火币");
        accountCoin.setCreateBy("1");
        accountCoin.setCreateTime(new Date());
        accountCoin.setLastUpdateFromIp("127.0.0.1");
        int i = accountCoinMapper.insertSelective(accountCoin.getAccountId(), accountCoin);
    }

    @Test
    public void updateSelectiveTest() {
        AccountCoinModel accountCoin = new AccountCoinModel();
        accountCoin.setAccountCoinId(1170248971126349826L);
        accountCoin.setAccountId(3L);
        accountCoin.setCoinName("USDT");
        accountCoin.setLastUpdateFromIp("127.0.0.1");
        int i = accountCoinMapper.updateSelective(accountCoin.getAccountId(), accountCoin);
    }

    @Test
    public void getByAccountIdTest() {
        List<AccountCoinModel> list = accountCoinMapper.getByAccountId(1164074920108494851L);
        System.out.println(list);
    }

    @Test
    public void modifyAccountCoinAmountTest() {
        AccountCoinModel accountCoin = new AccountCoinModel();
        accountCoin.setAccountCoinId(1166215305781968898L);
        accountCoin.setTotalAmount(BigDecimal.valueOf(1));
        accountCoin.setUsableAmount(BigDecimal.valueOf(0.5));
        accountCoin.setFrozenAmount(BigDecimal.valueOf(0.5));
        int i = accountCoinMapper.modifyAccountCoinAmount(1164074920108494851L, accountCoin);
    }

    @Test
    public void getOneAccountCoinSelectiveTest() {
        AssetsCoinQueryParamDto dto = new AssetsCoinQueryParamDto();
        dto.setExchangeCoinId("2");
        AccountCoinModel accountCoin = accountCoinMapper.getOneAccountCoinSelective(2L, dto);
        System.out.println(accountCoin);
    }

    @Test
    public void getAccountCoinListByAccountIdTest() {
        List<AssetsAccountCoinDto> list = accountCoinMapper.getAccountCoinListByAccountId(1164073804746592258L);
        System.out.println(list);
    }

    @Test
    public void queryCoinAmountByAccountIdAndExchCoinIdTest() {
        QueryAssetsCoinAmountDto dto = new QueryAssetsCoinAmountDto();
        dto.setAccountId(1164074920108494850L);
        dto.setExchangeCoinId("8");
        AssetsCoinUsableAmountDto result = accountCoinMapper.queryCoinAmountByAccountIdAndExchCoinId(1164074920108494850L, dto);
        System.out.println(result);
    }
    @Test
    public void getCoinInfoByAccountIdAndExchCoinIdTest() {
        AssetsCoinInfoReqData dto = new AssetsCoinInfoReqData();
        dto.setAccountId(1164074920108494850L);
        dto.setExchangeCoinId("8");
        AssetsCoinInfoResData result = accountCoinMapper.getCoinInfoByAccountIdAndExchCoinId(1164074920108494850L, dto);
        System.out.println(result);
    }




}
