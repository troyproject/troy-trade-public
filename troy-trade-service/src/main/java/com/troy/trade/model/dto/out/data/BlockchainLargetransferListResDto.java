package com.troy.trade.model.dto.out.data;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 链上转账返回实体DTO
 *
 * @author yanping
 */
@Getter
@Setter
public class BlockchainLargetransferListResDto extends ResData {

    /**
     * 币种名称
     */
    private List<BlockchainLargetransferResDto> blockchainLargetransferResDtoList;
}
