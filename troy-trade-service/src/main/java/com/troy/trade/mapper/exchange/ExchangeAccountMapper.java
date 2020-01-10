package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.ExchangeAccountIdReqDto;
import com.troy.trade.api.model.dto.in.report.AccountClearReqDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchangeAccountResDto;
import com.troy.trade.model.domain.exchange.ExchangeAccountModel;
import com.troy.trade.model.dto.out.report.ExchangeAccountResDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeAccountMapper extends BaseMapper<ExchangeAccountModel> {

    /**
     * 根据交易所code获取账户ID
     * @author yanping
     * @param exchangeAccountIdReqDto
     * @return
     */
    List<Long> getExchangeAccountIdByExchCode(ExchangeAccountIdReqDto exchangeAccountIdReqDto);

    /**
     * 根据交易所code获取一条账户信息
     * @param exchangeCodeResDto
     * @return
     */
    ExchangeAccountModel getExchangeAccountByExchCode(ExchangeCodeResDto exchangeCodeResDto);

    /**
     * 查询所有启用状态的账户信息
     * @return
     */
    List<ExchangeAccountResDto> queryAccountInfo(AccountClearReqDto accountClearReqDto);

    /**
     * 查询所有启用状态的账户信息，账户ID、账户名称
     * @return
     */
    List<AdminExchangeAccountResDto> queryAllAdminExchangeAccount();
}