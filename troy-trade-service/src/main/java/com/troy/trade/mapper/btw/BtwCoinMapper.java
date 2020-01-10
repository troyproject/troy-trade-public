package com.troy.trade.mapper.btw;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.btw.BtwCoinModel;
import com.troy.trade.model.dto.in.btw.BtwCoinReqDto;
import org.springframework.stereotype.Repository;

/**
 * btw 币种信息
 * @author yanping
 * @date 2019/10/23
 */
@Repository
public interface BtwCoinMapper extends BaseMapper<BtwCoinModel> {

    /**
     * 根据交易所code获取币种列表
     * @author yanping
     * @return
     */
    String getDepositAddress(BtwCoinReqDto btwCoinReqDto);
}
