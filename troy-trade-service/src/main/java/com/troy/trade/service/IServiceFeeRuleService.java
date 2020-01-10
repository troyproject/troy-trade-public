package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.trade.api.model.dto.in.spot.ServiceFeeRuleReqDto;
import com.troy.trade.api.model.dto.in.spot.SpotLevelRuleReqDto;
import com.troy.trade.api.model.dto.out.account.level.ServiceFeeRuleResDto;

import java.util.List;


public interface IServiceFeeRuleService {

    Res<ResList<ServiceFeeRuleResDto>> queryByLevel(SpotLevelRuleReqDto reqDto);

    Res batchUpdate(List<ServiceFeeRuleReqDto> reqDtoList);

    public Res batchInsert(List<ServiceFeeRuleReqDto> reqDtoList);

    Res insert(ServiceFeeRuleReqDto reqDto);
}
