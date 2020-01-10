package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 交易对列表查询返回实体
 *
 * @author yanping
 * @date 2019/08/16
 */
@Setter
@Getter
public class FavoriteSymbolListResDto extends ResData {

    /**
     * 所有
     */
    private List<FavoriteSymbolResDto> favoriteSymbolResDtoList;
}
