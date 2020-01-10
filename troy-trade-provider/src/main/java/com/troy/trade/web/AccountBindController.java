package com.troy.trade.web;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResFactory;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.exception.enums.StateTypeSuper;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.AccountSpotBalanceResDto;
import com.troy.trade.api.model.dto.out.account.UpdateAcctIdResDto;
import com.troy.trade.api.model.dto.out.account.assets.MarginBalanceResDto;
import com.troy.trade.api.model.dto.out.exchange.AccountBindInfoResDto;
import com.troy.trade.api.model.dto.out.exchange.BindNetworkExportResDto;
import com.troy.trade.api.model.dto.out.exchange.NetworkExportResDto;
import com.troy.trade.api.service.AccountBindApi;
import com.troy.trade.service.IAccountBindService;
import com.troy.trade.service.IExchangeAccountService;
import com.troy.trade.service.INetworkExportService;
import com.troy.trade.service.impl.AsyncServiceImpl;
import com.troy.trade.util.BusinessMethodsUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "账户绑定服务")
public class AccountBindController extends AbstractController implements AccountBindApi {

    @Autowired
    IAccountBindService accountBindService;

    @Autowired
    AsyncServiceImpl asyncService;

    @Autowired
    IExchangeAccountService exchangeAccountService;

    @Autowired
    BusinessMethodsUtil businessMethodsUtil;

    @Autowired
    INetworkExportService networkExportService;

    /**
     * 根据账户绑定ID查询用户绑定信息
     *
     * @param accountBindIdReqDtoReq
     * @return
     */

    @Override
    public Res<AccountBindInfoResDto> getBindInfos(@RequestBody Req<AccountBindIdReqDto> accountBindIdReqDtoReq){
        AccountBindIdReqDto accountBindIdReqDto = accountBindIdReqDtoReq.getData();
        Res<AccountBindInfoResDto> adminExchangeAccountResDtos = accountBindService.getBindInfos(accountBindIdReqDto.getAccountBindId());
        return adminExchangeAccountResDtos;
    }

    @Override
    public Res<ResList<AccountBindInfoResDto>> list() {
        Res<ResList<AccountBindInfoResDto>> adminExchangeAccountResDtos = accountBindService.list();
        return adminExchangeAccountResDtos;
    }
    @Override
    public Res<ResList<AccountBindInfoResDto>> getBindInfosByBindIds(@RequestBody Req<AccountBindIdReqDto> accountBindIdReqDtoReq) {
        AccountBindIdReqDto accountBindIdReqDto = accountBindIdReqDtoReq.getData();
        Res<ResList<AccountBindInfoResDto>> resListRes = accountBindService.getBindInfosByBindIds(accountBindIdReqDto);
        return resListRes;
    }

    @Override
    public Res<UpdateAcctIdResDto> updateAcctId(@RequestBody Req<UpdateAcctIdReqDto> updateAcctIdReqDtoReq) {
        UpdateAcctIdReqDto updateAcctIdReqDto = updateAcctIdReqDtoReq.getData();
        boolean result = asyncService.toUpdateThirdAcctId(updateAcctIdReqDto);
        UpdateAcctIdResDto updateAcctIdResDto = new UpdateAcctIdResDto();
        updateAcctIdResDto.setResult(result);
        return ResFactory.getInstance().success(updateAcctIdResDto);
    }

    @Override
    public Res bindExch(@RequestBody Req<AccountBindExchReqData> accountBindExchReqData) {
        AccountBindExchReqData data = accountBindExchReqData.getData();
        data.setUserId(getCurrentUser());
        int res = accountBindService.accoutBindWithExch(data);
        return res > 0 ? ResFactory.getInstance().success(null) : ResFactory.getInstance().createRes(StateTypeSuper.FAIL_DEFAULT);
    }

    @Override
    public Res<BindNetworkExportResDto> getBindExportIp() {
        List<String> exportIps = networkExportService.getExportIps();
        BindNetworkExportResDto bindNetworkExportResDto=new BindNetworkExportResDto();
        bindNetworkExportResDto.setExportIps(exportIps);
        return ResFactory.getInstance().success(bindNetworkExportResDto);
    }

    @Override
    public Res<ResList<NetworkExportResDto>> getAllExportIp() {
        List<NetworkExportResDto> networkExportResDtos = networkExportService.queryAllNetworkExport();
        return ResFactory.getInstance().successList(networkExportResDtos);
    }

    @Override
    public Res<AccountSpotBalanceResDto> getBalanceOfExchange(@RequestBody Req<AccountBindBalanceReqData> accountBindBalanceReqDataReq) {
        AccountBindBalanceReqData data = accountBindBalanceReqDataReq.getData();
        Res<AccountSpotBalanceResDto> balanceOfExchange = accountBindService.getBalanceOfExchange(data);
        return balanceOfExchange;
    }

    @Override
    public Res unbindExch(@RequestBody Req<AccountUnbindReqData> accountUnbindReqData) {
        AccountUnbindReqData data = accountUnbindReqData.getData();
        int res = accountBindService.unBindAccount(data);
        return res > 0 ? ResFactory.getInstance().success(null) : ResFactory.getInstance().createRes(StateTypeSuper.FAIL_DEFAULT);

    }

    @Override
    public Res<ResList<MarginBalanceResDto>> getMarginBalance(@RequestBody Req<AccountBindBalanceReqData> accountBindBalanceReqDataReq) {
        AccountBindBalanceReqData data = accountBindBalanceReqDataReq.getData();
        Res<ResList<MarginBalanceResDto>> marginBalance = accountBindService.getMarginBalance(data);
        return marginBalance;
    }

}
