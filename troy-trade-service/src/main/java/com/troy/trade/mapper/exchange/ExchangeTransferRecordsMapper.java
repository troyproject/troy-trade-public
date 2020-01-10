package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.exchange.ExchangeTransferRecordsModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeTransferRecordsMapper extends BaseMapper<ExchangeTransferRecordsModel> {

    /**
     * 获取提现状态为非最终状态的数据
     * @return
     */
    List<ExchangeTransferRecordsModel> getNotFinishedInfo();

    /**
     * 修改数据
     * @param exchangeTransferRecordsModel
     * @return
     */
    Integer updateExchStatusTxid(ExchangeTransferRecordsModel exchangeTransferRecordsModel);
}
