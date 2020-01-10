package com.troy.trade.model.enums;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
public enum WalletFailResponseCodeEnum {

    internal_error(1000, "内部错误"),
    ip_prohibits_access(4000, "IP禁止访问"),
    no_access(4001, "禁止访问"),
    request_too_fast(4002, "请求过快"),
    failure_to_verify_signature(4003, "验证签名失败"),
    Blacklist(4004, "黑名单"),
    openkey_does_not_have_permissions(4005, "openKey没有权限"),
    parameter_error(4006, "参数错误"),
    header_parameter_error(4007, "头部参数错误"),
    request_parameters_are_the_same(4008, "请求参数相同"),
    timestamp_error(4009, "时间戳错误"),
    openkey_does_not_exist(4010, "openKey不存在"),
    failure_to_verify_required_parameters(4011, "必填参数校验失败"),
    handling_failure(5001, "处理失败");

    private Integer code;

    private String msg;

    WalletFailResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WalletFailResponseCodeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (WalletFailResponseCodeEnum codeEnum : WalletFailResponseCodeEnum.values()) {
            if (codeEnum.code.equals(code)){
                return codeEnum;
            }
        }
        return null;
    }
}
