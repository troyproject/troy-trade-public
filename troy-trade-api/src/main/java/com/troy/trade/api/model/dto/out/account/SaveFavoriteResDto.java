package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 创建订单返回参数
 *
 * @author sz
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveFavoriteResDto extends ResData {

    /**
     * 返回 是否收藏成功 大于0 为成功
     */
    private int count;
}
