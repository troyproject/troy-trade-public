package com.troy.trade.service;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.Res;
import com.troy.commons.dto.out.ResPage;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.ExchangeAccountIdReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeAccountReqDto;
import com.troy.trade.api.model.dto.in.exchange.ExchangeDepositAddressReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchAcctWithdrawReqDto;
import com.troy.trade.api.model.dto.in.report.AccountClearReqDto;
import com.troy.trade.api.model.dto.out.account.CallExchangeInfoAccountResDto;
import com.troy.trade.api.model.dto.out.account.ExchangeAccountIdResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeAccountDetailResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.ExchangeDepositAddressResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchAcctWithdrawResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchangeAccountResDto;
import com.troy.trade.exchange.api.model.dto.out.account.QueryBalanceResDto;
import com.troy.trade.model.domain.exchange.ExchangeAccountModel;
import com.troy.trade.model.dto.in.BalanceOfExchangeReq;
import com.troy.trade.model.dto.in.CallExchangeInfoReq;
import com.troy.trade.model.dto.out.CallExchangeInfoRes;
import com.troy.trade.model.dto.out.report.ExchangeAccountResDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author yanping
 */
public interface IExchangeAccountService extends IBaseService<ExchangeAccountModel> {

    /**
     * 根据交易所code获取账户ID
     * @author yanping
     * @param exchangeAccountIdReqDto
     * @return
     */
    ExchangeAccountIdResDto getExchangeAccountIdByExchCode(ExchangeAccountIdReqDto exchangeAccountIdReqDto);

    /**
     * 根据交易所code获取一条账户信息
     * @param exchangeCodeResDto
     * @return
     */
    ExchangeAccountModel getExchangeAccountByExchCode(ExchangeCodeResDto exchangeCodeResDto);

    /**
     * 查询调用交易所信息（本系统唯一查询方法，如需APIKEY调用交易所，均需要调用该方法获得）
     *
     * <pre>
     *  交易调用API请使用返回对象中的tradeExchangeApi
     *  市场调用API请使用返回对象中的marketExchangeApi
     * </pre>
     *
     * @param callExchangeInfoReq
     * @return
     */
    CallExchangeInfoRes getCallExchangeInfo(CallExchangeInfoReq callExchangeInfoReq);

    /**
     * 查询调用交易所信息,查询账户未解密信息
     *
     * @param callExchangeInfoReq
     * @return
     */
    CallExchangeInfoAccountResDto getCallExchangeInfoNoDecode(CallExchangeInfoReq callExchangeInfoReq);

    /**
     * 获取交易所账户余额
     *
     * @param balanceOfExchangeReq
     * @return
     */
    List<QueryBalanceResDto> balanceOfExchange(BalanceOfExchangeReq balanceOfExchangeReq);

    /**
     * 获取绑定账户交易所账户余额
     *
     * @param accountBindId
     * @return
     */
    List<QueryBalanceResDto> bindAcctBalanceOfExchange(Long accountBindId);

    /**
     * 获取交易所账户余额
     *
     * @param exchAcctId
     * @return
     */
    List<QueryBalanceResDto> troyAcctBalanceOfExchange(Long exchAcctId);

    /**
     * 查询所有启用状态的账户信息
     * @return
     */
    List<ExchangeAccountResDto> queryAccountInfo(AccountClearReqDto accountClearReqDto);

    /**
     * 根据条件查询交易所账户信息
     * @return
     */
    ResPage<ExchangeAccountDetailResDto> queryExchangeAccountByCondition(ExchangeAccountReqDto reqDto);

    /**
     * 新增交易所账户
     * @param reqDto
     * @return
     */
    Res save(ExchangeAccountReqDto reqDto);

    /**
     * 根据主键查询交易所账户信息
     * @param exchAcctId
     * @return
     */
    Res<ExchangeAccountDetailResDto> queryByPrimaryKey(Long exchAcctId);

    Res modifyById(ExchangeAccountReqDto reqDto);

    /**
     * 查询所有启用状态的账户信息，账户ID、账户名称
     * @return
     */
    List<AdminExchangeAccountResDto> queryAllAdminExchangeAccount();

    /**
     *
     * @param adminExchAcctWithdrawReqDtoReq
     * @retur
     */
    Res<AdminExchAcctWithdrawResDto> withdraw(Req<AdminExchAcctWithdrawReqDto> adminExchAcctWithdrawReqDtoReq);

    /**
     * 充币地址查询
     * @param exchangeDepositAddressReqDtoReq
     * @return
     */
    Res<ExchangeDepositAddressResDto> depositAddress(@RequestBody Req<ExchangeDepositAddressReqDto> exchangeDepositAddressReqDtoReq);

}
