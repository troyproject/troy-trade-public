package com.troy.trade.api.model.dto.in;

import com.troy.commons.dto.in.ReqPage;

/**
 * @author yanping
 */
public class AuthReqData extends ReqPage {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
