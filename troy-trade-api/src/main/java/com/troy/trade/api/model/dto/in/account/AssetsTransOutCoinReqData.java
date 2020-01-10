package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsTransOutCoinReqData extends ReqData {

    @ApiModelProperty(value = "转出交易所code")
    private String transOutExchCode;

    @ApiModelProperty(value = "转入交易所code")
    private String transInExchCode;

}
