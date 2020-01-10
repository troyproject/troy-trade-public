package com.troy.trade.mapper.btw;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.btw.BtwBalanceRecordsModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BtwBalanceRecordsMapper extends BaseMapper<BtwBalanceRecordsModel> {

    void batchInsert(List<BtwBalanceRecordsModel> list);
}
