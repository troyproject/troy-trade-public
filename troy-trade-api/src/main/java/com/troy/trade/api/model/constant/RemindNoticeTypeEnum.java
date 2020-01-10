package com.troy.trade.api.model.constant;

/**
 * 消息提醒类型
 */
public enum RemindNoticeTypeEnum {

    /**
     * 身份认证
     */
    AUTH(0),
    /**
     * 充提币
     */
    DRAW_DEPOSIT(1);

    private Integer code;

    RemindNoticeTypeEnum(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
