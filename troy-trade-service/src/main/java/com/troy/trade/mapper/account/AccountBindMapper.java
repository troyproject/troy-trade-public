package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.AccountBindDetailsReqData;
import com.troy.trade.api.model.dto.in.account.AccountBindIdReqDto;
import com.troy.trade.api.model.dto.out.account.AccountBindDetailsResData;
import com.troy.trade.api.model.dto.out.exchange.AccountBindInfoResDto;
import com.troy.trade.model.domain.account.AccountBindModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountBindMapper extends BaseMapper<AccountBindModel> {

    AccountBindDetailsResData selectByAccountId(AccountBindDetailsReqData reqData) throws Exception;

    /**
     * 根据账户类型查找账户绑定信息
     * @param accountBindIdReqDto
     * @return
     */
    List<AccountBindInfoResDto> getBindInfosByBindIds(AccountBindIdReqDto accountBindIdReqDto);

    List<AccountBindInfoResDto> list();
}
