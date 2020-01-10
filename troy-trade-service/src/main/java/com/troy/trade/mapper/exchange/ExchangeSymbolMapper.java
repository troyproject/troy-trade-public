package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolIdsReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolDetailReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeSymbolReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeSymbolDetailResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeSymbolResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeSymbolsResDto;
import com.troy.trade.model.domain.exchange.ExchangeSymbolModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author zhangchengjie
 * @date 2019/08/16
 */
@Repository
public interface ExchangeSymbolMapper extends BaseMapper<ExchangeSymbolModel> {

    /**
     * 批量保存数据
     * @author yanping
     * @param exchangeSymbolModelList
     * @return
     */
    int insertBatch(List<ExchangeSymbolModel> exchangeSymbolModelList);

    /**
     * 批量修改数据
     * @param exchangeSymbolModelList
     * @return
     */
    int updateBatch(List<ExchangeSymbolModel> exchangeSymbolModelList);

    /**
     * 根据交易所code获取交易对列表
     * @param exchangeCodeResDto
     * @author yanping
     * @return
     */
    List<ExchangeSymbolModel> getExchangeSymbolModelByExchCode(ExchangeCodeResDto exchangeCodeResDto);

    /**
     * 根据参数查找交易对信息
     * @param exchangeSymbolDetailReqDto
     * @author yanping
     * @return
     */
    ExchangeSymbolDetailResDto getExchangeSymbolDetail(ExchangeSymbolDetailReqDto exchangeSymbolDetailReqDto);

    /**
     * 根据参数参选交易对数据
     * @param exchangeSymbolReqDto
     * @return
     */
    List<ExchangeSymbolsResDto> queryExchangeSymbolsByCondition(ExchangeSymbolReqDto exchangeSymbolReqDto);

    List<ExchangeSymbolResDto> listByIds(ExchangeSymbolIdsReqDto data);
}
