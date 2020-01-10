package com.troy.trade.service;

import com.troy.trade.api.model.dto.in.account.WalletExtractCoinQueryReqData;
import com.troy.trade.api.model.dto.in.account.WalletRechargeCoinNotifyReqData;
import com.troy.trade.api.model.dto.out.account.AssetsExtractCoinAuditDto;
import com.troy.trade.api.model.dto.out.account.WalletCoinAmountDto;
import com.troy.trade.model.domain.account.AccountCoinTellerModel;
import com.troy.trade.model.dto.in.WalletNewAddrQueryDto;
import com.troy.trade.model.dto.out.WalletApplyCoinOutDto;
import com.troy.trade.model.dto.out.WalletExtractCoinQueryResDto;
import com.troy.trade.util.WalletResponse;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/09/03
 */
public interface IWalletService {

    /* ---------------- recharge coin operations -------------- */

    /**
     * 1.1获取新的充币地址
     *
     * @param walletNewAddrQueryDto
     * @return
     */
    WalletResponse<String> newAddress(WalletNewAddrQueryDto walletNewAddrQueryDto);

    /**
     * 2.2充币通知
     *
     * @param reqData
     * @param openKey
     * @param signature
     * @param timestamp
     * @param requestIp
     * @return
     */
    String rechargeCoinNotify(WalletRechargeCoinNotifyReqData reqData,
                              String openKey,
                              String signature,
                              String timestamp,
                              String requestIp);

    /**
     * 定时充币状态查询
     * <p>
     * 1.3充币信息查询确认
     */
    void walletRechargeCoinConfirm();

    /* ---------------- extract coin operations -------------- */

    /**
     * 提现申请审核通过
     *
     * @param paramTeller
     * @return code = false 当BTW余额不足以进行提币
     */
    AssetsExtractCoinAuditDto auditAccountCoinExtractApply(AccountCoinTellerModel paramTeller);

    boolean handleExtractCoin(AssetsExtractCoinAuditDto auditDto, AccountCoinTellerModel teller);

    /**
     * 1.2提币申请
     *
     * @param walletApplyCoinOutDto
     * @return
     */
    WalletResponse<String> applyCoinOut(WalletApplyCoinOutDto walletApplyCoinOutDto);

    /**
     * 1.10 提币过滤接口（白名单过滤）
     *
     * @param walletApplyCoinOutDto
     * @return
     */
    WalletResponse<String> applyCoinOutFilter(WalletApplyCoinOutDto walletApplyCoinOutDto);

    /**
     * 根据币种获取余额
     *
     * @param coinName
     * @return
     */
    WalletResponse<String> queryAmount(String coinName);

    /**
     * 获取全部货币余额
     * @return
     */
    WalletResponse<List<WalletCoinAmountDto>> amountList();

    /**
     * 2.1提币信息确认
     *
     * @param reqData
     * @param openKey
     * @param signature
     * @param timestamp
     * @param requestIp
     * @return
     */
    String extractCoinQuery(WalletExtractCoinQueryReqData reqData,
                            String openKey,
                            String signature,
                            String timestamp,
                            String requestIp);

    /**
     * 提币状态查询
     *
     * @param guid
     * @return
     */
    WalletResponse<WalletExtractCoinQueryResDto> extractCoinQuery(String guid);

    /**
     * 定时提币状态查询
     * <p>
     * 1.4提币信息查询
     */
    void walletExtractCoinQueryTask();

    /* ---------------- query bill operations -------------- */

    /**
     * 定时任务-归集账单查询
     */
    void queryBillListTask();

}
