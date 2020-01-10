package com.troy.trade.api.service;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthAddReqData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthCancelReqData;
import com.troy.trade.api.model.dto.in.account.auth.AccountAuthListReqData;
import com.troy.trade.api.model.dto.out.account.auth.AccountAuthListResData;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 账户授权服务
 *
 * @author Han
 */
public interface AccountAuthApi {

    /**
     * 新增账户授权
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa212/auth/add")
    Res<ResData> add(Req<AccountAuthAddReqData> req);

    /**
     * 取消授权
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa212/auth/cancel")
    Res<ResData> cancel(Req<AccountAuthCancelReqData> req);

    /**
     * 我的授权
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa212/auth/my")
    Res<AccountAuthListResData> myAuthority(Req<AccountAuthListReqData> req);

    /**
     * 授权给我
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/aa212/auth/to-me")
    Res<AccountAuthListResData> authorizeToMe(Req<AccountAuthListReqData> req);
}