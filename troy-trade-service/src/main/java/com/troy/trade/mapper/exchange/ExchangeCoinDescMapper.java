package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinDescReqDto;
import com.troy.trade.model.domain.exchange.ExchangeCoinDescModel;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yanping
 * @date 2019/10/12
 */
@Repository
public interface ExchangeCoinDescMapper extends BaseMapper<ExchangeCoinDescModel> {

    /**
     * 修改交易所币种描述
     * @param adminExchangeCoinDescReqDto
     * @author yanping
     * @return
     */
    Integer updateExchCoinDesc(AdminExchangeCoinDescReqDto adminExchangeCoinDescReqDto);
}
