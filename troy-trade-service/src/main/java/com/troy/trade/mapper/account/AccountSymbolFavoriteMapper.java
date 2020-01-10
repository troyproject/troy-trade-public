package com.troy.trade.mapper.account;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.account.AccountSymbolFavoriteModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangchengjie
 * @date 2019/08/15
 */
@Repository
public interface AccountSymbolFavoriteMapper extends BaseMapper<AccountSymbolFavoriteModel> {


    void batchInsert(@Param("list") List<AccountSymbolFavoriteModel> symbolFavoriteModelList);
}
