package com.troy.trade.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
@Setter
@Getter
public class WalletResponse<T> implements Serializable {

    static final long serialVersionUID = 42L;

    /**
     * btw success response code
     */
    private static final int SUCCESS_CODE = 200;

    /**
     * success成功、fail失败
     */
    private String result;

    /**
     * result=success, code=200
     * result=fail,code异常码
     */
    private Integer code;

    /**
     * 响应数据
     */
    private T data;

    public boolean isSuccess() {
        return StringUtils.isNotEmpty(this.result) && this.code != null && this.code == SUCCESS_CODE;
    }

    public boolean isFail() {
        return !this.isSuccess();
    }

}
