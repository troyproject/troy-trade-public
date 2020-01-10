package com.troy.trade.mapper.account;

import com.troy.trade.api.model.dto.in.account.AssetsAccountCoinReqData;
import com.troy.trade.api.model.dto.in.account.AssetsCoinInfoReqData;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExcessCoinInfoReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExcessTurnInfoReqDto;
import com.troy.trade.api.model.dto.out.account.AssetsAccountCoinDto;
import com.troy.trade.api.model.dto.out.account.AssetsCoinInfoResData;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExcessCoinInfoResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExcessTurnInfoResDto;
import com.troy.trade.configurator.TableShardConstant;
import com.troy.trade.model.domain.account.AccountCoinModel;
import com.troy.trade.model.dto.in.AssetsCoinQueryParamDto;
import com.troy.trade.model.dto.in.QueryAssetsCoinAmountDto;
import com.troy.trade.model.dto.out.AssetsCoinUsableAmountDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户币种Mapper
 *
 * <p>
 * account_coin分表逻辑：根据账户id取模
 * 表名规则：account_coin_part_{index}
 * index = account_id % table_number
 * account_id：当前账户币种所属账户id
 * table_number：账户币种需要拆分表的数量
 * <p>
 * 使用sharding-jdbc路由数据库表
 *
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountCoinMapper {

    AccountCoinModel getById(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                             @Param("accountCoinId") Long accountCoinId);

    int insertSelective(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                        @Param("accountCoin") AccountCoinModel accountCoinModel);

    int updateSelective(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                        @Param("accountCoin") AccountCoinModel accountCoinModel);

    List<AccountCoinModel> getByAccountId(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId);

    int modifyAccountCoinAmount(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                                @Param("updateAccountCoin") AccountCoinModel updateAccountCoin);

    AccountCoinModel getOneAccountCoinSelective(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                                                @Param("queryParam") AssetsCoinQueryParamDto assetsCoinQueryParamDto);

    List<AssetsAccountCoinDto> getAccountCoinList(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                                                  @Param("accountCoinReq") AssetsAccountCoinReqData accountCoinReq);

    List<AssetsAccountCoinDto> getAccountCoinListByAccountId(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId);

    AssetsCoinUsableAmountDto queryCoinAmountByAccountIdAndExchCoinId(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                                                                      @Param("queryAssetsCoinAmountDto") QueryAssetsCoinAmountDto queryAssetsCoinAmountDto);

    AssetsCoinInfoResData getCoinInfoByAccountIdAndExchCoinId(@Param(TableShardConstant.AccountCoin.SHARD_BY) Long shardAccountId,
                                                              @Param("chargeAddrReq") AssetsCoinInfoReqData chargeAddrReq);

    BigDecimal getCoinTotalAmount(@Param("masterAccountId") Long masterAccountId,@Param("coinName") String coinName);

    BigDecimal getCoinTotalAmountByUserId(@Param("userId") Long userId,@Param("coinName") String coinName);

    /**
     * 获取所有账户的币种总额 分交易所和币种
     * @return
     */
    List<AdminExcessCoinInfoResDto> getAccountTotalAssetsByExch(AdminExcessCoinInfoReqDto adminExcessCoinInfoReqDto);

    /**
     * 根据账户ID和币种名称查询币种转移详情
     * @return
     */
    List<AdminExcessTurnInfoResDto> getAccountTotalAssetsDetail(AdminExcessTurnInfoReqDto adminExcessTurnInfoReqDto);

    List<AccountCoinModel> queryByModel(AccountCoinModel queryCoinMode);

    List<AccountCoinModel> queryByHours(int hour);
}
