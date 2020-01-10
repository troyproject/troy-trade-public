package com.troy.trade.model.dto.in;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 资产账户币种修改Dto
 *
 * @author zhangchengjie
 * @date 2019/08/19
 */
@Setter
@Getter
public class AssetsCoinChangeDto {

    /**
     * 操作币种集合
     */
    private List<AssetsCoinOpt> assetsCoinOptList;

}
