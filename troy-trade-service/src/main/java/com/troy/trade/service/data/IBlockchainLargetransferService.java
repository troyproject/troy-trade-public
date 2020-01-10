package com.troy.trade.service.data;

import com.github.pagehelper.PageInfo;
import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.model.domain.data.BlockchainLargetransferModel;
import com.troy.trade.model.dto.in.data.LargetransferReqDto;
import com.troy.trade.model.dto.out.data.BlockchainLargetransferListResDto;
import com.troy.trade.model.dto.out.data.BlockchainLargetransferResDto;

import java.util.List;
import java.util.Map;

/**
 * 服务接口
 *
 * @author yanping
 */
public interface IBlockchainLargetransferService extends IBaseService<BlockchainLargetransferModel> {

    /**
     * 批量保存数据
     *
     * @throws Throwable
     * @author yanping
     */
    int insertBatch(List<BlockchainLargetransferModel> blockchainLargetransferModelList) throws Throwable;

    /**
     * 获取当前币种信息
     * @param paramMap coin-币种名称
     * @return
     */
    BlockchainLargetransferModel getLastBlockchainLargetransfer(Map<String, Object> paramMap) throws Throwable;

    /**
     * 获取全量脸上转账数据
     * @param largetransferReqDto coinName-币种名称
     * @return
     */
    PageInfo<BlockchainLargetransferResDto> getBlockchainLargetransfers(LargetransferReqDto largetransferReqDto) throws Throwable;

    /**
     * 查询大额转账列表
     * @return
     */
    BlockchainLargetransferListResDto largetransfer();
}
