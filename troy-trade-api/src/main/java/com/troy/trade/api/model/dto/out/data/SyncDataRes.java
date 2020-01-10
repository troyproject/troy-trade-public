package com.troy.trade.api.model.dto.out.data;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SyncDataRes extends ResData {

    /**
     * 返回结果
     */
    private String result;
}
