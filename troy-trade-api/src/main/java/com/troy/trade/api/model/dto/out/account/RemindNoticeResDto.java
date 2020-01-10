package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemindNoticeResDto extends ResData {

    private Integer remindType;

    /**
     * 人员名称(多个逗号分隔)
     */
    private String member;

    /**
     * 手机号(多个逗号分隔)
     */
    private String phone;

}
