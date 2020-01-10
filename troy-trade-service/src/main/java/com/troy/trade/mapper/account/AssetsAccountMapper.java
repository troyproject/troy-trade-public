package com.troy.trade.mapper.account;

import com.troy.trade.api.model.dto.in.account.AssetsMyselfAccountListReqData;
import com.troy.trade.api.model.dto.out.account.AssetsAccountExch;
import com.troy.trade.api.model.dto.out.account.AssetsMyselfAccountExch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 资产账户Mapper
 * <p>
 * 该Mapper没有对应的数据表，仅仅是基于资产账户提取出来的
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Repository
public interface AssetsAccountMapper {

    /**
     * 我的资产账户列表
     *
     * @param userId
     * @return
     */
    List<AssetsAccountExch> getAssetsAccountExchList(Long userId);

    /**
     * 授权资产账户列表
     *
     * @param userId
     * @return
     */
    List<AssetsAccountExch> getAuthAssetsAccountExchList(Long userId);

    /**
     * 充提币-我的账户列表
     *
     * @param reqData
     * @return
     */
    List<AssetsMyselfAccountExch> getMyselfAccountExchList(@Param("reqData") AssetsMyselfAccountListReqData reqData);

}