package com.troy.trade.service;

import com.troy.commons.dto.out.Res;
import com.troy.trade.exchange.api.model.dto.out.account.ExchAcctDeptWdralResDto;
import com.troy.trade.model.dto.in.exchange.ExchAcctDeptWdralReqDto;

/**
 * 账户充提记录查询服务
 * @author yanping
 */
public interface IExchAcctDeptWdralService {


    /**
     * 根据参数查询账户充提记录信息服务
     * 传txid的话会根据txid查，不传txid的话，gateio交易所必须传申请时间、非gateio交易所传提现ID
     *
     * @param exchAcctDeptWdralReqDto
     * @author yanping
     * @return
     */
    Res<ExchAcctDeptWdralResDto> queryExchAcctDeptWdralInfo(ExchAcctDeptWdralReqDto exchAcctDeptWdralReqDto);
}
