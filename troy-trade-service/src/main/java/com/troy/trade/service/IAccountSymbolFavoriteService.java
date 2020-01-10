package com.troy.trade.service;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.out.Res;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.account.AccountSymbolFavoriteListReqDto;
import com.troy.trade.api.model.dto.in.account.AccountSymbolFavoriteReqDto;
import com.troy.trade.api.model.dto.out.account.FavoriteSymbolResDto;
import com.troy.trade.api.model.dto.out.account.SaveFavoriteResDto;
import com.troy.trade.model.domain.account.AccountSymbolFavoriteModel;

import java.util.List;

/**
 * @author sz
 */
public interface IAccountSymbolFavoriteService extends IBaseService<AccountSymbolFavoriteModel> {


    /**
     * 收藏列表
     * @param req
     * @return
     */
    List<FavoriteSymbolResDto> getFavoriteList(Req<AccountSymbolFavoriteListReqDto> req);

    /**
     * 添加和取消收藏
     * @param req
     * @return
     */
    Res<SaveFavoriteResDto> saveFavorite(Req<AccountSymbolFavoriteReqDto> req);

    /**
     * 获取未登录的时候默认收藏
     * @return
     */
    List<FavoriteSymbolResDto>  getDfaultFavoriteList();

    /**
     * 注册后 默认插入收藏
     * @param userId
     * @return
     */
    Integer saveDefaultFavorite(Long userId);
}
