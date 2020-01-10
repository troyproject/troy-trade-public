package com.troy.trade.service.data;

import com.troy.trade.exchange.api.model.dto.out.data.AbnormalChangesResDto;

import java.util.List;

/**
 * 市场异动信息操作服务
 * @author yanping
 */
public interface IAbnormalChangesService {

    /**
     * 市场异动数据列表
     * @author yanping
     * @return
     */
    List<AbnormalChangesResDto> abnormalChanges();
}
