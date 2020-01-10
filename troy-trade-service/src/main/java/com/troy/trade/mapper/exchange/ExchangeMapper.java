package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.exchange.ExchangeListReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeQueryListReqData;
import com.troy.trade.api.model.dto.in.exchange.ExchangeTypeListReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeDetails;
import com.troy.trade.api.model.dto.out.exchange.ExchangeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeTypeResDto;
import com.troy.trade.model.domain.exchange.ExchangeModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/16
 */
@Repository
public interface ExchangeMapper extends BaseMapper<ExchangeModel> {

    List<ExchangeDetails> selectForExchangeDetails(ExchangeQueryListReqData reqData) throws IOException;

    /**
     * 获取所有交易所code列表
     * @author yanping
     * @return
     * @throws Throwable
     */
    List<ExchangeCodeResDto> getExchCode() throws Throwable;

    /**
     * 根据状态获取交易所列表
     * @return
     * @throws Throwable
     */
    List<ExchangeResDto> getExchangeList() throws Throwable;

    /**
     * 根据交易所类型查找交易所code列表
     * @author yanping
     * @param exchangeTypeListReqDto
     * @return
     */
    List<ExchangeTypeResDto> getExchCodeByType(ExchangeTypeListReqDto exchangeTypeListReqDto);

    /**
     * 根据类型，交易所查询交易所列表
     * @param exchangeListReqDto
     * @return name，aliasName
     */
    List<ExchangeResDto> getExchCodesByTypes(ExchangeListReqDto exchangeListReqDto);
}