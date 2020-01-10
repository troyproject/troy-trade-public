package com.troy.trade.service.btw;

import com.troy.commons.dto.out.ResPage;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.BtwBalanceRecordsReqData;
import com.troy.trade.api.model.dto.out.data.BtwBalanceRecordsResData;
import com.troy.trade.model.domain.btw.BtwBalanceRecordsModel;

import java.util.List;

public interface IBtwBalanceRecordsService extends IBaseService<BtwBalanceRecordsModel> {

    void batchInsert(List<BtwBalanceRecordsModel> list);

    void syncBtwBalanceRecords();

    ResPage<BtwBalanceRecordsResData> getRecords(BtwBalanceRecordsReqData reqData);

    ResPage<BtwBalanceRecordsResData> getRecordsExample(BtwBalanceRecordsReqData reqData);
}
