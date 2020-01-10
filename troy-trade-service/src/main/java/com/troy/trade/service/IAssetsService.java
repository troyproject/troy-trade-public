package com.troy.trade.service;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.ResData;
import com.troy.trade.api.model.dto.in.account.*;
import com.troy.trade.api.model.dto.out.account.*;
import com.troy.trade.assets.AssetsCoinLogEvent;
import com.troy.trade.model.domain.account.AccountCoinModel;
import com.troy.trade.model.dto.in.AssetsCoinOpt;
import com.troy.trade.model.dto.in.AssetsCoinQueryParamDto;
import com.troy.trade.model.dto.in.QueryAssetsCoinAmountDto;
import com.troy.trade.model.dto.out.AssetsCoinUsableAmountDto;

/**
 * 账户资产Service
 *
 * @author zhangchengjie
 * @date 2019/08/16
 */
public interface IAssetsService {

    /**
     * 根据条件查询账户币种AccountCoinModel
     *
     * @param assetsCoinQueryParamDto
     * @return
     */
    AccountCoinModel getAccountCoinSelective(AssetsCoinQueryParamDto assetsCoinQueryParamDto);

//    /**
//     * 账户列表
//     *
//     * @param req
//     * @return
//     */
//    AssetsAccountListResData getAccountList(Req<AssetsAccountListReqData> req);

    /**
     * 账户币种列表
     *
     * @param reqData
     * @return
     */
    AssetsAccountCoinInfoResData getAccountCoinList(AssetsAccountCoinReqData reqData);

    /**
     * 计算账户可用总金额
     *
     * @param accountId
     * @return
     */
//    AssetsAmountCalculateResDto calculateAssetsTotalAmount(Long accountId);

    /**
     * 操作账户币种数量
     *
     * @param assetsCoinOpt
     * @return
     * @throws RuntimeException
     */
    Boolean modifyAccountCoinAmount(AssetsCoinOpt assetsCoinOpt) throws RuntimeException;

    /**
     * 记录账户币种金额变动日志
     *
     * @param assetsCoinLogEvent
     */
    void handleModifyAccountCoinAmountLog(AssetsCoinLogEvent assetsCoinLogEvent);

    /**
     * 查询资产账户币种余额
     * <p>
     * return null if account_coin not exist or account_status=0
     *
     * @param queryAssetsCoinAmountDto
     * @return
     */
    AssetsCoinUsableAmountDto queryAssetsCoinAmount(QueryAssetsCoinAmountDto queryAssetsCoinAmountDto);

//    /**
//     * 充提币-我的账户列表
//     *
//     * @param req
//     * @return
//     */
//    AssetsMyselfAccountListResData getMyselfAccountList(Req<AssetsMyselfAccountListReqData> req);

    /**
     * 充提转币-获取账户币种详情
     *
     * @param reqData
     * @return
     */
    AssetsCoinInfoResData getCoinInfo(AssetsCoinInfoReqData reqData);

//    /**
//     * 生成充币地址
//     *
//     * @param reqData
//     * @return
//     */
//    AssetsCoinInfoResData createChargeAddr(AssetsCoinInfoReqData reqData);

//    /**
//     * 查询充提币历史
//     *
//     * @param reqData
//     * @return
//     */
//    AssetsChargeHistoryResData getChargeHistory(AssetsChargeHistoryReqData reqData);

//    /**
//     * 获取提币详细信息
//     *
//     * @param reqData
//     * @return
//     */
//    AssetsExtractApplyInfoResData getExtractApplyInfo(AssetsCoinInfoReqData reqData);

    /**
     * 提币申请
     *
     * @param reqData
     * @return
     */
    ResData extractApply(AssetsExtractApplyReqData reqData);

    /**
     * 获取转出币种列表
     *
     * @param reqData
     * @return
     */
    AssetsTransOutCoinListResData getTransOutCoinList(AssetsTransOutCoinReqData reqData);

    /**
     * 转币
     *
     * @param reqData
     * @return
     */
    ResData transCoin(AssetsTransCoinReqData reqData);

    /**
     * 执行转币
     *
     * @param tellerId
     */
    void executeTransCoin(Long tellerId);

    /**
     * 标记提币到BTW成功
     * @param tellerId
     * @return
     */
    boolean markExtractToBTWSuccess(Long tellerId);

    /**
     * 运营人员手动划转币
     * @param tellerId
     * @param operType 1提币到交易所 2添加资产
     * @return
     */
    boolean adminExtractToExch(Long tellerId, Integer operType);

//    /**
//     * 获取转币记录
//     *
//     * @param reqData
//     * @return
//     */
//    AssetsTransCoinRecordResData getTransCoinRecord(AssetsTransCoinReqData reqData);

    /**
     * 查询交易币种信息
     * <p>
     * 查询一个交易账户交易对信息（账户币种ID accountCoinId、可用额usableAmount）
     *
     * @param queryDto
     * @return
     */
    TradeCoinInfoDto getTradeCoinInfo(TradeCoinInfoQueryDto queryDto);

    /**
     * 最新财务记录列表(新增)
     *
     * @param reqData
     * @return
     */
    AssetsFinanceRecordResData financialRecords(AssetsFinanceRecordReqData reqData);

    /**
     * 后台管理-最新财务记录列表
     * @param reqData
     * @return
     */
    AssetsFinanceRecordResData adminFinancialRecords(AssetsFinanceRecordReqData reqData);

    /**
     * 定时处理用户转币
     */
    void handleTransCoinTask();

    /**
     * 后台管理员转币
     *
     * @param tellerId
     * @return
     */
    Boolean adminTransCoin(Long tellerId);

    /**
     * 转入账户列表
     *
     * @param reqData
     * @return
     */
    AccountListResData getTransOutAccountList(AssetsTransCoinReqData reqData);

    /**
     * 查询账户资产（根据账户，交易所）
     * @param reqData
     * @return
     */
    AssetsAccountCoinInfoResData getAccountAssetsByAccount(AssetsAccountCoinReqData reqData);

    /**
     * 根据账户，币种，交易所，btc数量查询btc估值
     * @param reqData
     * @return
     */
    AssetsAccountExchCoinResDto getAccountCoinBtcAmount(AssetsAccountCoinByCoinReqData reqData);

    void updateToEnoughAmount(Long accountCoinTellerId);

    /**
     * 根据交易所code和币种名称查询交易所币种id
     *
     * @param reqData
     * @return
     */
    TransCoinExchCoinResData getExchCoinId(TransCoinExchCoinReqData reqData);
}
