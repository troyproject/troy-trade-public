package com.troy.trade.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.troy.commons.constraints.Log;
import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResData;
import com.troy.commons.dto.out.ResFactory;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.exception.enums.StateTypeSuper;
import com.troy.commons.exception.verification.VerificationException;
import com.troy.commons.proxy.GreedyRequestProxy;
import com.troy.commons.proxy.SimpleRequestProxy;
import com.troy.trade.api.model.constant.YesOrNo;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.*;
import com.troy.trade.api.model.dto.out.account.assets.AccountAssetsResData;
import com.troy.trade.api.model.dto.out.account.level.AccountLevelResData;
import com.troy.trade.api.model.dto.out.account.level.ServiceFeeResultDto;
import com.troy.trade.api.service.AccountApi;
import com.troy.trade.model.domain.exchange.ExchangeAccountModel;
import com.troy.trade.service.*;
import com.troy.user.dto.out.user.login.UserLoginLogResData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.index.qual.SameLen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author Han
 */
@Slf4j
@RestController
@Api(tags = "账户服务")
public class AccountController extends AbstractController implements AccountApi {

    @Autowired
    private IAccountService service;
    @Autowired
    IAccountSymbolFavoriteService accountSymbolFavoriteService;
    @Autowired
    private IServiceFeeService serviceFeeService;
    @Autowired
    private IAccountAuthService accountAuthService;
    @Autowired
    private IAccountOverAssetsService accountOverAssetsService;

    @Override
    @ApiOperation(value = "账户级别", notes = "账户级别")
    public Res<AccountLevelResData> level(@RequestBody Req<AccountFeeReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountFeeReqData, AccountLevelResData>) (reqHead, reqData) -> {
//            AccountLevelResData resData = this.service.level(super.currentUser().getUserId());

            return serviceFeeService.level(super.currentUser().getUserId());
        });
    }

    @Log(value = "账户资产总览", outputPrint = false)
    @Override
    @ApiOperation(value = "账户资产总览", notes = "账户资产总览")
    public Res<AccountAssetsResData> assets(@RequestBody Req<ReqData> req) {
        return super.process(req, (GreedyRequestProxy<ReqData, AccountAssetsResData>) (reqHead, reqData) -> {
            AccountAssetsResData resData = this.service.getAssetsDetails(super.currentUser().getUserId());
            return resData;
        });
    }

    @Override
    @ApiOperation(value = "账户绑定详情", notes = "账户绑定详情")
    public Res<AccountBindDetailsResData> boundDetails(@RequestBody Req<AccountBindDetailsReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountBindDetailsReqData, AccountBindDetailsResData>) (reqHead, reqData) -> {
            reqData.setUserId(super.currentUser().getUserId());
            AccountBindDetailsResData resData = this.service.getBoundDetails(reqData);
            return resData;
        });
    }

    @Override
    @ApiOperation(value = "解绑账户", notes = "解绑账户")
    public Res<ResData> unbind(@RequestBody Req<AccountUnbindReqData> req) {
        return super.process(req, (SimpleRequestProxy<AccountUnbindReqData>) (reqHead, reqData) -> {
            reqData.setUserId(super.currentUser().getUserId());
            this.service.unbind(reqData);
            return true;
        });
    }

    @Override
    @ApiOperation(value = "绑定账户", notes = "绑定账户")
    public Res<ResData> bind(@RequestBody Req<AccountBindReqData> req) {
        return super.process(req, (SimpleRequestProxy<AccountBindReqData>) (reqHead, reqData) -> {
            reqData.setUserId(super.currentUser().getUserId());
            this.service.bind(reqData);
            return true;
        });
    }

    @Override
    @ApiOperation(value = "注册账户", notes = "注册账户")
    public Res<ResData> register(@RequestBody Req<AccountRegisterReqData> req) {
        return super.process(req, (SimpleRequestProxy<AccountRegisterReqData>) (reqHead, reqData) -> {
            reqData.setUserId(super.currentUser().getUserId());
            this.service.register(reqData, false);
            return true;
        });
    }

    @Override
    @ApiIgnore
    public Res<ResData> register(@RequestBody AccountRegisterReqData reqData) {
        this.service.register(reqData, false);
        return ResFactory.getInstance().createRes();
    }

    @Override
    @ApiOperation(value = "我的账户列表", notes = "我的账户列表")
    public Res<AccountListResData> myAccountList(@RequestBody Req<AccountListReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountListReqData, AccountListResData>) (reqHead, reqData) -> {
            String token = super.tokenConverter.readAccessToken(super.currentRequest());
            Long userId = StringUtils.isEmpty(token) ? reqData.getUserId() : super.tokenConverter.convertAccessToken(token).getUserId();
            //只查询当前用户的正常账户
            reqData.setStatus(YesOrNo.YES.getCode());
            reqData.setUserId(userId);
            List<AccountDetails> list = this.service.getUserAccount(reqData);
            return new AccountListResData(list);
        });
    }

    @Override
    @ApiOperation(value = "我的账户列表和委托给自己的账户", notes = "我的账户列表和委托给自己的账户")
    public Res<AccountListResData> myAccountListV2(@RequestBody Req<AccountListReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountListReqData, AccountListResData>) (reqHead, reqData) -> {
            String token = super.tokenConverter.readAccessToken(super.currentRequest());
            Long userId = StringUtils.isEmpty(token) ? reqData.getUserId() : super.tokenConverter.convertAccessToken(token).getUserId();
            //只查询当前用户的正常账户
            reqData.setStatus(YesOrNo.YES.getCode());
            reqData.setUserId(userId);
            List<AccountDetails> list = this.service.getUserAccountAndAuth(reqData);
            return new AccountListResData(list);
        });

    }


    @Override
    @ApiOperation(value = "注册后 默认插入收藏", notes = "注册后 默认插入收藏")
    public Res<CreateDefaultFavoriteResDto> saveDefaultFavorite(@RequestBody Req<UserIdReqData> req) {
        UserIdReqData userIdReqData = req.getData();
        if (userIdReqData == null || userIdReqData.getUserId() == null) {
            throw new VerificationException(StateTypeSuper.FAIL_VALUE_INVALID, "userId");
        }
        accountSymbolFavoriteService.saveDefaultFavorite(userIdReqData.getUserId());
        return ResFactory.getInstance().success(new CreateDefaultFavoriteResDto(userIdReqData.getUserId()));
    }

    @Override
    @ApiOperation(value = "用户的账号列表", notes = "用户的账号列表")
    public Res<AccountDetailsPage> userAccountList(@RequestBody Req<AccountListReqData> req) {
        AccountListReqData userIdReqData = req.getData();
        if (userIdReqData == null || userIdReqData.getUserId() == null) {
            throw new VerificationException(StateTypeSuper.FAIL_VALUE_INVALID, "userId");
        }
        try {
            PageHelper.startPage(userIdReqData.getPageNum(), userIdReqData.getPageSize());
            List<AccountDetails> list = this.service.getUserAccount(userIdReqData);
            PageInfo<UserLoginLogResData> detailsPageInfo = new PageInfo(list);

            AccountDetailsPage pageInfoResDto = new AccountDetailsPage();
            if (detailsPageInfo.getSize() > 0) {
                pageInfoResDto.setList(list);
                pageInfoResDto.setTotal(detailsPageInfo.getTotal());
            }

            return ResFactory.getInstance().success(pageInfoResDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResFactory.getInstance().failParameter("");
    }

    @Override
    @ApiOperation(value = "账户级别", notes = "账户级别")
    public Res<ServiceFeeResultDto> levelRate(@RequestBody Req<AccountFeeReqData> req) {
        return super.process(req, (GreedyRequestProxy<AccountFeeReqData, ServiceFeeResultDto>) (reqHead, reqData) -> {
            if (StringUtils.isEmpty(req.getData().getExchCode())){
                throw new VerificationException(StateTypeSuper.FAIL_PARAMETER);
            }
            return serviceFeeService.getFeeByUserId(super.currentUser().getUserId(),req.getData().getExchCode());
        });
    }

    @Override
    public Res<ResData> hasAccountPermission(@RequestBody Req<AccountPermissionReqDto> req) {
        return super.process(req, (GreedyRequestProxy<AccountPermissionReqDto, ResData>) (reqHead, reqData) -> {
            String token = super.tokenConverter.readAccessToken(super.currentRequest());
            Long userId = StringUtils.isEmpty(token) ? reqData.getUserId() : super.tokenConverter.convertAccessToken(token).getUserId();
            if(userId == null){
                throw new VerificationException(StateTypeSuper.FAIL_PARAMETER);
            }
            accountAuthService.getAccountAuthDetail(reqData.getAccountId(), userId, reqData.getAccountPermissionType());
            return new ResData();
        });
    }

    @Override
    @ApiOperation(value = "分页查询超额资产列表", notes = "分页查询超额资产列表")
    public Res<OverAssetsListPageInfoResDto>  queryOverAssets(@RequestBody Req<OverAssetsReqData> req) {
        OverAssetsReqData reqData =  req.getData();
        log.debug("分页查询超额资产列表：", reqData.toString());
        return ResFactory.getInstance().success(accountOverAssetsService.queryOverAssets(reqData));

    }

    @Override
    public Res<AccountBindDetails> detail(@RequestBody Req<AccountBindDetailsReqData> req) {
        AccountBindDetailsReqData data = req.getData();
        AccountBindDetails accountDetails =new AccountBindDetails();
        try {
             accountDetails = service.getAccountDetails(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResFactory.getInstance().success(accountDetails);
    }


}
