package com.troy.trade.api.service;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.*;
import com.troy.trade.api.model.dto.out.account.assets.AccountAssetsResData;
import com.troy.trade.api.model.dto.out.account.level.AccountLevelResData;
import com.troy.trade.api.model.dto.out.account.level.ServiceFeeResultDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 账户服务
 *
 * @author Han
 */
public interface AccountApi {

    /**
     * 账户余额
     */
    @PostMapping(value = "/aa2/getBalance")
    Res<AccountLevelResData> getBalance(Req<AccountBalanceReqData> req);*/


    /**
     * 账户级别
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/level")
    Res<AccountLevelResData> level(Req<AccountFeeReqData> req);

    /**
     * 账户总资产
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/assets")
    Res<AccountAssetsResData> assets(Req<ReqData> req);

    /**
     * 绑定详情
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/bound-details")
    Res<AccountBindDetailsResData> boundDetails(Req<AccountBindDetailsReqData> req);

    /**
     * 解绑
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/unbind")
    Res<ResData> unbind(Req<AccountUnbindReqData> req);

    /**
     * 绑定
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/bind")
    Res<ResData> bind(Req<AccountBindReqData> req);

    /**
     * 注册
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/register")
    Res<ResData> register(Req<AccountRegisterReqData> req);

    /**
     * 钱包账户注册
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/wallet/register")
    Res<ResData> register(AccountRegisterReqData req);

    /**
     * 我的账户列表
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/list/my")
    Res<AccountListResData> myAccountList(Req<AccountListReqData> req);

    /**
     * 自有账户及委托给自己的账户
     * @param req
     * @return
     * @author caq
     */
    @PostMapping(value = "/aa2/list/my/v2")
    Res<AccountListResData> myAccountListV2(Req<AccountListReqData> req);

    /**
     * 注册后添加默认收藏
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/saveDefaultFavorite")
    Res<CreateDefaultFavoriteResDto> saveDefaultFavorite(Req<UserIdReqData> req);

    /**
     * 我的账户列表
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/xxxxx/dddddd/userAccountList")
    Res<AccountDetailsPage> userAccountList(Req<AccountListReqData> req);

    @PostMapping(value = "/aa2/levelRate")
    Res<ServiceFeeResultDto> levelRate(@RequestBody Req<AccountFeeReqData> req);

    /**
     * 查询用户是否具有对账户操作权限
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/permission")
    Res<ResData> hasAccountPermission(Req<AccountPermissionReqDto> req);

    /**
     * 分页查询超额资产列表
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/queryOverAssets")
    Res<OverAssetsListPageInfoResDto>  queryOverAssets(@RequestBody Req<OverAssetsReqData> req) ;



    /**
     * 根据accountId获取账户详情
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa2/detail")
    Res<AccountBindDetails> detail(Req<AccountBindDetailsReqData> req);


}
