package com.troy.trade.constant;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
public interface WalletConstant {

    /**
     * btw基础url
     */
    String REQUEST_BASE_URL = "http://www.baiud.com";

    /**
     * 获取新的充币地址url
     */
    String REQUEST_NEW_ADDRESS_URL = "/v1/operate/newAddress";

    /**
     * 提币申请url
     */
    String REQUEST_APPLY_COIN_OUT_URL = "/v1/operate/applyCoinOut";

    /**
     * 提币过滤接口（白名单过滤）
     */
    String REQUEST_APPLY_COIN_OUT_FILTER_URL = "/v1/operate/applyCoinOutFilter";

    /**
     * 充币信息查询确认url
     */
    String REQUEST_QUERY_CONFIRM_URL = "/v1/query/queryConfirm";

    /**
     * 提币币信息查询确认url
     */
    String REQUEST_QUERY_OUT_STATUS_URL = "/v1/query/queryOutStatus";

    /**
     * 根据币种获取余额
     */
    String REQUEST_QUERY_AMOUNT_URL = "/v1/query/amount";

    /**
     * 获取全部货币余额
     */
    String REQUEST_AMOUNT_LIST_URL = "/v1/query/amountList";

    /**
     * 归集账单信息获取
     */
    String REQUEST_QUERY_BILL_LIST_URL = "/v1/query/queryBillList";

    /**
     * 处理失败对BTW响应
     */
    String ERROR_RESPONSE = "fail";

    /**
     * 处理失败对BTW响应
     */
    String SUCCESS_RESPONSE = "success";


    String WALLET_ACCOUNT_CN_NAME = "钱包账户";

    String WALLET_ACCOUNT_EN_NAME = "Wallet Account";

}
