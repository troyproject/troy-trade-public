package com.troy.trade.api.model.dto.out.exchange.admin;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 币种超额列表字段返回
 *
 * @author yanping
 */
@Setter
@Getter
public class PageInfoAdminExcessCoinResDto extends ResData {


    /**
     * 币种信息
     */
    private List<AdminExcessCoinInfoResDto> adminExcessCoinInfoResDtoList;

    /**
     * 总数量
     */
    private long total;
}
