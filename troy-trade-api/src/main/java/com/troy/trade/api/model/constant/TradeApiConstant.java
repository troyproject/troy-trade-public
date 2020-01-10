package com.troy.trade.api.model.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 交易API Constant
 *
 * @author dp
 */
@Deprecated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TradeApiConstant {

    /**
     * 交易类型
     */
    public interface Order {

        /**
         * 限价交易
         */
        int TRADE_TYPE_LIMIT = 1;

        /**
         * 市价交易
         */
        int TRADE_TYPE_MARKET = 2;

        /**
         * 交易方向--买
         */
        int TRADE_SIDE_BUY = 1;

        /**
         * 交易方向--卖
         */
        int TRADE_SIDE_SELL = 2;

    }

    /**
     * The enum Order status enum.
     */
    public enum OrderStatusEnum {

        /**
         * 初始订单状态--初始入库为此状态
         */
        INIT_STATUS(0, "初始"),

        /**
         * 部分成交状态--订单未撤单，但是已成交部分的情况
         */
        PART_STATUS(1, "部分成交"),

        /**
         * 已撤销状态--最终状态
         */
        CANCEL_STATUS(2, "已撤销"),

        /**
         * 已成交--最终状态
         */
        DEAL_STATUS(3, "已成交"),

        /**
         * 部分撤销--最终状态，指订单未完全成交的情况下，进行撤单后的状态
         */
        PART_CANCEL_STATUS(4, "部分撤销"),

        /**
         * 已提交状态--已提交至交易所，交易状态待同步
         */
        COMMIT_STATUS(10, "已提交"),

        /**
         * 失败状态--订单提交至交易所，但交易所返回明确失败
         */
        FAIL_STATUS(11, "失败"),

        /**
         * 状态未知--订单提交至交易所，但交易所超时未返回
         */
        UNKNOW_STATUS(12, "状态未知"),

        /**
         * 撤单按钮被按下的状态，该状态最后会进行与交易所状态同步
         */
        CANCEL_APPLY__STATUS(13, "申请撤单");

        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        /**
         * Gets value.
         *
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * Gets code.
         *
         * @return the code
         */
        public int getCode() {
            return code;
        }

        /**
         * Code of order status enum.
         *
         * @param code the code
         * @return the order status enum
         */
        public static OrderStatusEnum codeOf(int code) {
            OrderStatusEnum result = null;
            for (OrderStatusEnum paymentTypeEnum : values()) {
                if (paymentTypeEnum.getCode() == code) {
                    result = paymentTypeEnum;
                    break;
                }
            }
            return result;
        }
    }


}
