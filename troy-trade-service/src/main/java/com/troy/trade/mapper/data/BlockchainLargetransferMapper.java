package com.troy.trade.mapper.data;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.data.BlockchainLargetransferModel;
import com.troy.trade.model.dto.in.data.LargetransferReqDto;
import com.troy.trade.model.dto.out.data.BlockchainLargetransferResDto;

import java.util.List;
import java.util.Map;

/**
 * 大额转账操作Dao
 *
 * @author yanping
 */
public interface BlockchainLargetransferMapper extends BaseMapper<BlockchainLargetransferModel> {

    /**
     * 批量保存数据
     *
     * @throws Throwable
     * @author yanping
     */
    int insertBatch(List<BlockchainLargetransferModel> blockchainLargetransferModelList);

    /**
     * 获取当前币种信息
     * @param paramMap coin-币种名称
     * @return
     */
    BlockchainLargetransferModel getLastBlockchainLargetransfer(Map<String, Object> paramMap);

    /**
     * 获取全量脸上转账数据
     * @param largetransferReqDto coinName-币种名称
     * @return
     */
    List<BlockchainLargetransferResDto> getBlockchainLargetransfers(LargetransferReqDto largetransferReqDto);
}
