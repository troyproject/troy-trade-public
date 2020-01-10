package com.troy.trade.web;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResData;
import com.troy.commons.proxy.GreedyRequestProxy;
import com.troy.commons.proxy.SimpleRequestProxy;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthAddReqData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthCancelReqData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthListReqData;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthListDetails;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthListResData;
import com.troy.trade.api.service.AccountAuthApi;
import com.troy.trade.service.IAccountAuthService;
import com.troy.user.dto.out.auth.token.CheckTokenResData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Han
 */
@RestController
@Api(tags = "账户授权服务")
public class AccountAuthController extends AbstractController implements AccountAuthApi {

    @Autowired
    private IAccountAuthService service;

    @Override
    @ApiOperation(value = "账户授权", notes = "账户授权")
    public Res<ResData> add(@RequestBody Req<AccountAuthAddReqData> req) {
        return super.process(req, (SimpleRequestProxy<AccountAuthAddReqData>) (reqHead, reqData) -> {
            CheckTokenResData checkTokenResData = super.currentUser();
            this.service.add(checkTokenResData.getUserId(), checkTokenResData.getUsername(), reqData);
            return true;
        });
    }

    @Override
    @ApiOperation(value = "取消授权", notes = "取消授权")
    public Res<ResData> cancel(@RequestBody Req<AccountAuthCancelReqData> req) {
        return super.process(req, (SimpleRequestProxy<AccountAuthCancelReqData>) (reqHead, reqData) -> {
            this.service.cancel(super.currentUser().getUserId(), reqData);
            return true;
        });
    }

    @Override
    @ApiOperation(value = "我的授权", notes = "我授权的账户列表")
    public Res<AccountAuthListResData> myAuthority(@RequestBody Req<AccountAuthListReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountAuthListReqData, AccountAuthListResData>) (reqHead, reqData) -> {
            List<AccountAuthListDetails> list = this.service.myAuthority(super.currentUser().getUserId(), reqData);
            return new AccountAuthListResData(list);
        });
    }

    @Override
    @ApiOperation(value = "授权给我", notes = "授权给我的账户列表")
    public Res<AccountAuthListResData> authorizeToMe(@RequestBody Req<AccountAuthListReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountAuthListReqData, AccountAuthListResData>) (reqHead, reqData) -> {
            List<AccountAuthListDetails> list = this.service.authorizeToMe(super.currentUser().getUserId(), reqData);
            return new AccountAuthListResData(list);
        });
    }
}
