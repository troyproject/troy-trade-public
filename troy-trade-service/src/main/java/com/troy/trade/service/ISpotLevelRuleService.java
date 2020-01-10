package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.spot.SpotLevelRuleReqDto;
import com.troy.trade.api.model.dto.out.account.SpotLevelRuleResDto;
import com.troy.trade.model.domain.account.SpotLevelRuleModel;



/**
 *
 */
public interface ISpotLevelRuleService extends IBaseService<SpotLevelRuleModel> {

    Res<ResList<SpotLevelRuleResDto>> queryByCondition();

    Res insert(SpotLevelRuleReqDto reqDto);
}
