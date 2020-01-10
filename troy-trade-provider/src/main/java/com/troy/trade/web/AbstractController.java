package com.troy.trade.web;

import com.troy.commons.BaseController;
import com.troy.commons.exception.business.TokenException;
import com.troy.user.client.auth.TokenConverter;
import com.troy.user.dto.out.auth.token.CheckTokenResData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base Controller
 *
 * @author Han
 */
public abstract class AbstractController extends BaseController {

    @Autowired
    protected TokenConverter tokenConverter;

    protected CheckTokenResData currentUser() throws Exception {
        CheckTokenResData checkTokenResData = this.tokenConverter.convertAccessToken(this.currentRequest());
        return checkTokenResData;
    }

    /**
     * 调用信息中获取token
     *
     * @return
     */
    protected long getCurrentUser(){
        try {
            return this.currentUser().getUserId();
        } catch (Exception e) {
            throw new TokenException("token获取用户失败");
        }
    }

}
