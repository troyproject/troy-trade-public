package com.troy.trade.api.model.constant;


import com.troy.commons.exception.enums.StateTypeSuper;

/**
 * description 服务响应状态
 *
 * @author Han
 * @date 2018/9/27 11:28
 */
public enum ServiceResState implements StateTypeSuper {

    // 异常命名：FAIL_异常类型
    // 错误编码：从 2000 起，使用示例：throw new ServiceException(ServiceResState.FAIL_CLIENT_NOT_EXIST);
    FAIL_ACCOUNT_DISABLED("2000", "账户被禁用"),
    FAIL_ACCOUNT_AUTH_DISABLED("2001", "账户授权已失效"),
    FAIL_ACCOUNT_UNBOUND("2002", "账户已解绑"),
    FAIL_NOT_FOUND_TRUSTEE("2003", "受托用户不存在"),
    LIMIT_ONE_ACCOUNT_TRANS_COIN("2004", "同一账户不能互相转币"),
    ACCOUNT_DOES_NOT_EXIST("2005", "账户不存在"),
    STATUS_IS_NOT_TO_BE_AUDITED("2006", "当前记录不是待审核状态"),
    REQUEST_BTW_FAIL("2007", "请求BTW钱包失败"),
    ADDR_CONFLICT_RECHARGE_EXTRACT("2008", "提币地址不能为该币种充币地址"),
    NOT_ENOUGH_AMOUNT("2009", "余额不足"),
    NO_RIGHT_TO_OPERATE_THIS_ACCOUNT("2010", "无权操作此账户"),
    FAIL_ACCOUNT_EXCHCODE_EXSITS ("2011","该账户已存在"),
    FAIL_DRAWCOINTELLER ("2012","提现调用接口错误返回"),
    FAIL_RETRY_TRANSCOIN ("2013","接口返回余额不足"),
    FAIL_PENDING_LIMIT ("2014","下单超限"),
    EXTRACT_COIN_AMOUNT_LESS_THAN_ZERO("2015","提币数量不能小于等于0"),
    TRANS_COIN_AMOUNT_LESS_THAN_ZERO("2016","转币数量需要大于手续费"),
    TRANS_COIN_AMOUNT_MIN("2017","转币数量需要大于等于最小转币数量"),
    EXTRACT_COIN_AMOUNT_MIN("2018","提币币数量需要小于单次提币数量限额"),
    EXTRACT_COIN_AMOUNT_MIN_GREATER_THAN("2019","提币币数量需要大于等于单次最小提币数量"),
    NO_RIGHT_TO_CHARGE_MONEY("2020","没有充币权限"),
    NO_RIGHT_TO_WITHDRAW_MONEY("2021","没有提币权限"),
    NO_RIGHT_TO_CHANGE_MONEY("2022","没有转币权限"),
    EXTRACT_COIN_AMOUNT_LESS_THAN_FEE("2023","提币数量需要大于手续费"),
    EOS_FOUR_DECIMAL("2024","eos提币数量只能精确到小数点后四位"),
    TRANSFER_ACCOUNT_DOES_NOT_BELONG_TO_THAT_USER("2025","转账账户不属于该用户"),
    FAIL_EXIST_COMMISSION("2026", "委托关系已存在"),
    FAIL_AUTH_MYSELF("2027", "不能授权给自己"),
    OTHER_COIN_DECIMAL("2028","币种精度不正确"),
    BTW_COIN_NO_SUPPORT("2029","BTW币种不支持"),
    TO_BTW_COIN_ING("2031","已有一笔转账BTW账户在途"),
    ACCOUNT_COIN_TELLER_NOT_EXIST("2033","充提转记录不存在"),
    FAIL_UPDATE_DATA("2034","更新数据错误"),
    FAIL_QUERY_DATA("2035","账户数据不存在"),
    FAIL_TRANSFER_CURRENCY("2036","手动划转币错误"),
    FAIL_BIND_ACCOUNT_BAN("2037","绑定账户已禁用"),
    FAIL_EXCH_ACCOUNT_BAN("2038","交易所账号已禁用"),
    FAIL_VERIFYCODE_CHECK("2039","验证码输入有误"),
    NO_CANCEL_ORDERS("2040","没有需要撤单的订单"),
    EXCH_COIN_NOT_EXIST("2041","交易所币种不存在"),
    FAIL_TOO_SMALL_CASH_AMOUNT("2042","下单金额太小"),
    FAIL_TOO_SMALL_AMOUNT("2043","下单量太小"),
    EXCH_COIN_NOT_TRANS("2044","转出交易所币种不可转币"),
    EXCH_NOT_RIGHT_TRANS("2045","无交易权限"),
    ACCOUNT_BIND_IP_INVALID("2046","绑定账户IP非法"),
    ACCOUNT_BIND_APIKEY_INVALID("2047","绑定账户APIKEY重复"),
    ACCOUNT_BIND_ACCOUNT_EXIST("2048","账户的名称已存在"),
    ACCOUNT_BIND_INVALID("2049","绑定账户时异常"),
    ACCOUNT_BIND_API_INVALID("2050","绑定账户apiKey或apiSecret错误"),
    ;

    private String code;
    private String depict;

    ServiceResState(String code, String depict) {
        this.code = code;
        this.depict = depict;
    }

    /**
     * description: 获取状态描述
     *
     * @param
     * @return 状态描述
     */
    @Override
    public String getDepict() {
        return depict;
    }

    /**
     * description:  获取状态码
     *
     * @param
     * @return 状态码
     */
    @Override
    public String getCode() {
        return code;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }
}
