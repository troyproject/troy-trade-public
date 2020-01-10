package com.troy.trade.service;

import com.alibaba.fastjson.JSON;
import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.*;
import com.troy.trade.model.domain.account.AccountCoinModel;
import com.troy.trade.model.dto.in.AssetsCoinOpt;
import com.troy.trade.model.dto.in.AssetsCoinQueryParamDto;
import com.troy.trade.model.dto.in.QueryAssetsCoinAmountDto;
import com.troy.trade.model.dto.out.AssetsCoinUsableAmountDto;
import com.troy.trade.model.enums.AssetsCoinOptSourceEnum;
import com.troy.trade.model.enums.AssetsCoinOptTypeEnum;
import com.troy.trade.util.ConstantTest;
import com.troy.trade.util.ReqBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhangchengjie
 * @date 2019/08/23
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
@Slf4j
public class AssetsServiceTest {

    @Autowired
    private IAssetsService assetsService;
    @Autowired
    private IServiceFeeService iServiceFeeService;

    @Before
    public void before() {
        log.info("===============before unit test execute===============");
    }

    @Test
    public void getAccountCoinSelectiveTest() {
        AssetsCoinQueryParamDto paramDto = new AssetsCoinQueryParamDto();
        paramDto.setAccountId(1L);
        paramDto.setExchangeCoinId("1");
        AccountCoinModel accountCoinModel = assetsService.getAccountCoinSelective(paramDto);
        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(accountCoinModel));
    }

//    @Test
//    public void getAccountListTest() {
//        AssetsAccountListReqData reqData = new AssetsAccountListReqData();
//        reqData.setAssetsType(AssetsAccountListReqData.ASSETS_TYPE_1);
//        reqData.setUserId(1L);
//        Req<AssetsAccountListReqData> req = ReqBuilder.build(reqData);
//
//        AssetsAccountListResData resData = assetsService.getAccountList(req);
//        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resData));
//    }

    @Test
    public void getAccountCoinListTest() {
        AssetsAccountCoinReqData reqData = new AssetsAccountCoinReqData();
        reqData.setAccountId(1L);
        reqData.setExchCode("Binance");
        Req<AssetsAccountCoinReqData> req = ReqBuilder.build(reqData);

        AssetsAccountCoinInfoResData resData = assetsService.getAccountCoinList(req.getData());
        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resData));
    }

    @Test
    public void modifyAccountCoinAmount() {
        AssetsCoinOpt assetsCoinOpt = new AssetsCoinOpt();
        assetsCoinOpt.setOptType(AssetsCoinOptTypeEnum.add.getOptType());
        assetsCoinOpt.setAccountId(1L);
        assetsCoinOpt.setAccountCoinId(3L);
        assetsCoinOpt.setOptSource(AssetsCoinOptSourceEnum.trans.getOptSource());
        assetsCoinOpt.setSpotTransId(123L);
        assetsCoinOpt.setUpdateBy("1");
        assetsCoinOpt.setLastUpdateFromIp("127.0.0.1");
        assetsCoinOpt.setOptNumber(new BigDecimal(.5));
        assetsCoinOpt.setRollbackNumber(new BigDecimal(.5));

        assetsService.modifyAccountCoinAmount(assetsCoinOpt);
    }

    @Test
    public void queryAssetsCoinAmountTest() {
        QueryAssetsCoinAmountDto queryDto = new QueryAssetsCoinAmountDto(1L, "1");
        queryDto.setAccountId(1L);
        queryDto.setExchangeCoinId("1");

        AssetsCoinUsableAmountDto resultDto = assetsService.queryAssetsCoinAmount(queryDto);
        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resultDto));
    }

//    @Test
//    public void getMyselfAccountListTest() {
//        AssetsMyselfAccountListReqData reqData = new AssetsMyselfAccountListReqData();
//        reqData.setUserId(1L);
//        Req<AssetsMyselfAccountListReqData> req = ReqBuilder.build(reqData);
//
//        AssetsMyselfAccountListResData resData = assetsService.getMyselfAccountList(req);
//        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resData));
//    }

    @Test
    public void getChargeAddrTest() {
        AssetsCoinInfoReqData reqData = new AssetsCoinInfoReqData();
        reqData.setUserId(1L);
        reqData.setAccountId(1L);
        reqData.setExchangeCoinId("1");

        AssetsCoinInfoResData resData = assetsService.getCoinInfo(reqData);
        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resData));
    }

//    @Test
//    public void createChargeAddrTest() {
//        // 三种情况：已经存在地址、已经开户没有地址、没有开户
//        AssetsCoinInfoReqData reqData = new AssetsCoinInfoReqData();
//        reqData.setAccountId(2L);
//        reqData.setExchangeCoinId("3");
//        reqData.setUserId(1L);
//        reqData.setLastUpdateFromIp("127.0.0.1");
//
//        AssetsCoinInfoResData resData = assetsService.createChargeAddr(reqData);
//        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resData));
//    }
//
//    @Test
//    public void getChargeHistoryTest() {
//        AssetsChargeHistoryReqData reqData = new AssetsChargeHistoryReqData();
//        reqData.setAccountCoinId(1L);
//        reqData.setUserId(1L);
//        reqData.setOperType(1L);
//
//        AssetsChargeHistoryResData chargeHistory = assetsService.getChargeHistory(reqData);
//        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(chargeHistory));
//    }

//    @Test
//    public void calculateAssetsTotalAmountTest() {
//        AssetsAmountCalculateResDto resDto = assetsService.calculateAssetsTotalAmount(1L);
//        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(resDto));
//    }

//    @Test
//    public void getExtractApplyInfoTest() {
//        AssetsCoinInfoReqData reqData = new AssetsCoinInfoReqData();
//        reqData.setUserId(1L);
//        reqData.setAccountId(1L);
//        reqData.setExchangeCoinId("6");
//        AssetsExtractApplyInfoResData extractApplyInfo = assetsService.getExtractApplyInfo(reqData);
//        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(extractApplyInfo));
//    }

    @Test
    public void extractApplyTest() {
        AssetsExtractApplyReqData reqData = new AssetsExtractApplyReqData();
        reqData.setUserId(1L);
        reqData.setAccountId(1L);
        reqData.setAccountCoinId(1L);
        reqData.setAddr(UUID.randomUUID().toString().replace("-", ""));
        reqData.setAmount(BigDecimal.valueOf(87));
        reqData.setSaveAddr(1);
        reqData.setRemark("备注");
        assetsService.extractApply(reqData);
    }

    @Test
    public void getTradeCoinInfoTest() {
        TradeCoinInfoQueryDto tradeCoinInfoQueryDto = new TradeCoinInfoQueryDto();
        tradeCoinInfoQueryDto.setAccountId(1L);
        tradeCoinInfoQueryDto.setBaseExchangeCoinId("1");
        tradeCoinInfoQueryDto.setQuoteExchangeCoinId("2");
        tradeCoinInfoQueryDto.setUserId(1L);
        TradeCoinInfoDto tradeCoinInfo = assetsService.getTradeCoinInfo(tradeCoinInfoQueryDto);
        log.info(ConstantTest.LOG_LINE + "{}\n " + ConstantTest.LOG_LINE, JSON.toJSONString(tradeCoinInfo));
    }

    @Test
    public void transCoinTest() {
        AssetsTransCoinReqData reqData = new AssetsTransCoinReqData();
        reqData.setUserId(1L);
        reqData.setOutAccountId(1L);
        reqData.setOutAccountCoinId(1L);
        reqData.setTransAmount(BigDecimal.valueOf(.5));

        ResData resData = assetsService.transCoin(reqData);
    }

    @Test
    public void test() {
        AccountDetails a1 = new AccountDetails();
        a1.setBtcAmount(BigDecimal.valueOf(1));

        AccountDetails a2 = new AccountDetails();
        a2.setBtcAmount(BigDecimal.valueOf(0.5));

        AccountDetails a3 = new AccountDetails();
        a3.setBtcAmount(BigDecimal.valueOf(2));

        AccountDetails a4 = new AccountDetails();
        a4.setBtcAmount(BigDecimal.valueOf(-1));

        List<AccountDetails> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);

        Collections.sort(list);

        System.out.println(list);
    }

}
