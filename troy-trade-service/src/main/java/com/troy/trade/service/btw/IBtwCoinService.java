package com.troy.trade.service.btw;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.model.domain.btw.BtwCoinModel;
import com.troy.trade.model.domain.report.ExchAcctClearModel;
import com.troy.trade.model.dto.in.btw.BtwCoinReqDto;
import com.troy.trade.model.dto.in.report.ExchAcctClearReqDto;

import java.util.List;

/**
 * @author yanping
 */
public interface IBtwCoinService extends IBaseService<BtwCoinModel> {

    /**
     * 根据交易所code获取币种列表
     * @author yanping
     * @return
     */
    String getDepositAddress(BtwCoinReqDto btwCoinReqDto);

}
