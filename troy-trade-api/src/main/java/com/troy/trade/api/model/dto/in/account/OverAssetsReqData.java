package com.troy.trade.api.model.dto.in.account;

import com.troy.trade.api.model.dto.in.AuthReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Han
 */
@Setter
@Getter
public class OverAssetsReqData extends AuthReqData {

    private static final long serialVersionUID = 2996290231512350161L;


    private String coin;

    private String exchCode;


}
