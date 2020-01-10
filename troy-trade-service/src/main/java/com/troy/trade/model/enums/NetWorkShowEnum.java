package com.troy.trade.model.enums;

public enum NetWorkShowEnum {

    UN_SHOW(0,"不展示"),
    SHOW(1,"展示"),
    ;

    private Integer code;//账户描述
    private String desc;//账户分类型

    NetWorkShowEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
