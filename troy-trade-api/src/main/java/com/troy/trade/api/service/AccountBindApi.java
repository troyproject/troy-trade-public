package com.troy.trade.api.service;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.AccountSpotBalanceResDto;
import com.troy.trade.api.model.dto.out.account.UpdateAcctIdResDto;
import com.troy.trade.api.model.dto.out.account.assets.MarginBalanceResDto;
import com.troy.trade.api.model.dto.out.exchange.AccountBindInfoResDto;
import com.troy.trade.api.model.dto.out.exchange.BindNetworkExportResDto;
import com.troy.trade.api.model.dto.out.exchange.NetworkExportResDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 绑定账户服务
 *
 * @author yanping
 */
public interface AccountBindApi {

    /**
     * 根据账户绑定ID查询用户绑定信息
     *
     * @param accountBindIdReqDtoReq
     * @return
     */
    @PostMapping(value = "/xxx/xxxx/xxxx")
    Res<AccountBindInfoResDto> getBindInfos(@RequestBody Req<AccountBindIdReqDto> accountBindIdReqDtoReq);

    /**
     * 所有数据
     * @return
     */
    @PostMapping(value = "/33/444/xxxx")
    Res<ResList<AccountBindInfoResDto>> list();
    /**
     * 根据账户绑定ID列表查询用户绑定信息
     *
     * @param accountBindIdReqDtoReq
     * @return
     */
    @PostMapping(value = "/xxxx/xxxx/xxxx")
    Res<ResList<AccountBindInfoResDto>> getBindInfosByBindIds(@RequestBody Req<AccountBindIdReqDto> accountBindIdReqDtoReq);

    /**
     * 查询用户绑定信息
     *
     * @param updateAcctIdReqDtoReq
     * @return
     */
    @PostMapping(value = "/xxxx/xxx/xx")
    Res<UpdateAcctIdResDto> updateAcctId(@RequestBody Req<UpdateAcctIdReqDto> updateAcctIdReqDtoReq);


    /**
     * 用户绑定账户
     *
     */
    @PostMapping(value = "/xxxxx/accountBind/bindExch")
    Res bindExch(@RequestBody Req<AccountBindExchReqData> accountBindExchReqData);

    /**
     * 获取用户ip
     */
    @RequestMapping(value = "/xxxxx/accountBind/getExportIp")
    Res<BindNetworkExportResDto> getBindExportIp();


    @PostMapping(value = "/xxxxx/accountBind/getAllExportIp")
    Res<ResList<NetworkExportResDto>> getAllExportIp();


    /**
     * 获取用户账户信息
     *
     */
    @PostMapping(value = "/xxxxx/accountBind/getBalanceOfExchange")
    Res<AccountSpotBalanceResDto> getBalanceOfExchange(@RequestBody Req<AccountBindBalanceReqData> accountBindBalanceReqDataReq);


    /**
     * 用户解绑账户
     *
     */
    @PostMapping(value = "/xxxxx/accountBind/unbindExch")
    Res unbindExch(@RequestBody Req<AccountUnbindReqData> accountUnbindReqData);


    /**
     * 获取用户杠杆账户信息
     */
    @PostMapping(value = "/xxxxx/accountBind/getMarginBalance")
    Res<ResList<MarginBalanceResDto>> getMarginBalance(@RequestBody Req<AccountBindBalanceReqData> accountBindBalanceReqDataReq);


}
