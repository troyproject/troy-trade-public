package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.AccountBindDetailsReqData;
import com.troy.trade.api.model.dto.out.account.AccountBindDetailsResData;
import com.troy.trade.model.domain.account.AccountBindModel;
import com.troy.trade.model.domain.account.AccountOverAssetsModel;
import org.springframework.stereotype.Repository;

/**
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountOverAssetsMapper extends BaseMapper<AccountOverAssetsModel> {


}
