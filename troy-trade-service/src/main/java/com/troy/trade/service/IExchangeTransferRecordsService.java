package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.ExchangeTransferRecordsReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeTransferRecordPageInfoResDto;
import com.troy.trade.model.domain.account.AccountAuthModel;
import com.troy.trade.model.domain.exchange.ExchangeTransferRecordsModel;

import java.util.List;

public interface IExchangeTransferRecordsService extends IBaseService<ExchangeTransferRecordsModel> {

    Res insert(ExchangeTransferRecordsReqDto reqDto);

    ExchangeTransferRecordPageInfoResDto queryTransferRecords(ExchangeTransferRecordsReqDto reqData);

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
