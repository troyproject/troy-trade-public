package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.exchange.ExchangeQueryListReqData;
import com.troy.trade.api.model.dto.in.exchange.ExchangeTypeListReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeDetails;
import com.troy.trade.api.model.dto.out.exchange.ExchangeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeTypeResDto;
import com.troy.trade.model.domain.exchange.ExchangeModel;
import com.troy.trade.model.domain.exchange.ExchangeParentModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 */
@Repository
public interface ExchangeParentMapper extends BaseMapper<ExchangeParentModel> {

}