package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.out.account.SpotLevelRuleResDto;
import com.troy.trade.model.domain.account.SpotLevelRuleModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author sz
 * @date 2019/09/22
 */
@Repository
public interface SpotLevelRuleMapper extends BaseMapper<SpotLevelRuleModel> {

    List<SpotLevelRuleResDto> queryByCondition();

    Integer queryMaxLevel();

    SpotLevelRuleModel queryMaxId();

}
