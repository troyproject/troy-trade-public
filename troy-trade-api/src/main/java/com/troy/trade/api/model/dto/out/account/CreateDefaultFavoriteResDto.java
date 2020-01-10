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
public class CreateDefaultFavoriteResDto extends ResData {

    private Long userId;
}
