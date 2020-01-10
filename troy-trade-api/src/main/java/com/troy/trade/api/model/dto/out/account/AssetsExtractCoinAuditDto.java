package com.troy.trade.api.model.dto.out.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 转币历史记录
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AssetsExtractCoinAuditDto implements Serializable {

    static final long serialVersionUID = 42L;

    private boolean code;

    private String msg;

}

