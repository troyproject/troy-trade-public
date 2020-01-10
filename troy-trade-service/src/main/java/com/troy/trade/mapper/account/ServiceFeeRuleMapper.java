package com.troy.trade.mapper.account;

import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResList;
import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.spot.ServiceFeeRuleReqDto;
import com.troy.trade.api.model.dto.in.spot.SpotLevelRuleReqDto;
import com.troy.trade.api.model.dto.out.account.level.ServiceFeeRuleResDto;
import com.troy.trade.model.domain.account.ServiceFeeRuleModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author zhangchengjie
 * @date 2019/09/20
 */
@Repository
public interface ServiceFeeRuleMapper extends BaseMapper<ServiceFeeRuleModel> {

    void batchUpdate(List<ServiceFeeRuleReqDto> reqDtoList);

    void batchInsert(List<ServiceFeeRuleReqDto> reqDtoList);

    List<ServiceFeeRuleResDto> queryByLevel(SpotLevelRuleReqDto reqDto);
}
