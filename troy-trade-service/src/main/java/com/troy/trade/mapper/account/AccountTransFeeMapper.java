package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.out.order.OrderDetails;
import com.troy.trade.model.domain.account.AccountTransFeeModel;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountTransFeeMapper extends BaseMapper<AccountTransFeeModel> {



    BigDecimal queryFeeByOrder(OrderDetails transFlow);
}
