package com.troy.trade.mapper.account;

import com.troy.trade.model.domain.account.SpotDayBtcModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 *
 * @author sz
 * @date 2019/09/22
 */
@Repository
public interface SpotDayBtcMapper  {

    void insert(SpotDayBtcModel btcModel);

    SpotDayBtcModel groupByUserId(@Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("userId") Long userId);
}
