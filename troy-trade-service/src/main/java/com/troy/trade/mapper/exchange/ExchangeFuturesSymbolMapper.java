package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.exchange.ExchangeFuturesCodeReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeFuturesSymbolDetailReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolDetailReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeSymbolDetailResDto;
import com.troy.trade.model.domain.exchange.ExchangeFuturesSymbolModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author caq
 * @date 2019/12/12
 */
@Repository
public interface ExchangeFuturesSymbolMapper extends BaseMapper<ExchangeFuturesSymbolModel> {

    /**
     * 批量保存数据
     * @param list
     * @return
     */
    int insertBatch(List<ExchangeFuturesSymbolModel> list);

    /**
     * 根据交易所code获取交易对列表
     * @param exchangeFuturesCodeReqDto
     * @return
     */
    List<ExchangeFuturesSymbolModel> getExchangeSymbolModelByExchCode(ExchangeFuturesCodeReqDto exchangeFuturesCodeReqDto);

    /**
     * 根据参数查找交易对信息
     * @param exchangeSymbolDetailReqDto
     * @return
     */
    ExchangeSymbolDetailResDto getExchangeSymbolDetail(ExchangeFuturesSymbolDetailReqDto exchangeSymbolDetailReqDto);

}