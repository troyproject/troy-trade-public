package com.troy.trade.model.dto.in.data;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LargetransferReqDto extends ReqData {

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;
}
