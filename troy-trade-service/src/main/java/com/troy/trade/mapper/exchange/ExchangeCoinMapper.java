package com.troy.trade.mapper.exchange;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.in.account.AssetsTransOutCoinReqData;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinBaseReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinDetailReqDto;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminExchangeCoinReqDto;
import com.troy.trade.api.model.dto.out.account.AssetsTransOutCoinResData;
import com.troy.trade.api.model.dto.out.exchange.ExchangeCodeResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchangeCoinDetailResDto;
import com.troy.trade.api.model.dto.out.exchange.admin.AdminExchangeCoinResDto;
import com.troy.trade.model.domain.exchange.ExchangeCoinModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author yanping
 * @date 2019/08/30
 */
@Repository
public interface ExchangeCoinMapper extends BaseMapper<ExchangeCoinModel> {

    /**
     * 批量新增数据
     * @param exchangeCoinModelList
     * @return
     */
    int insertBatch(List<ExchangeCoinModel> exchangeCoinModelList);

    /**
     * 批量修改数据
     * @param exchangeCoinModelList
     * @return
     */
    int updateBatch(List<ExchangeCoinModel> exchangeCoinModelList);

    /**
     * 根据交易所code获取币种列表
     * @param exchangeCodeResDto
     * @author yanping
     * @return
     */
    List<ExchangeCoinModel> getExchangeCoinModelByExchCode(ExchangeCodeResDto exchangeCodeResDto);

    /**
     * 根据交易所code和币种获取币种
     * @param exchangeCodeResDto
     * @author yanping
     * @return
     */
    ExchangeCoinModel getCoinModelByExchCode(ExchangeCodeResDto exchangeCodeResDto);

    /**
     * 转币-查询转出币种
     *
     * @param reqData
     * @return
     */
    List<AssetsTransOutCoinResData> getTransOutCoinList(@Param("reqData") AssetsTransOutCoinReqData reqData);

    List<ExchangeCoinModel> selectList();

    /**
     * 根据条件查询币种信息列表
     *
     * @param adminExchangeCoinReqDto
     * @author yanping
     * @return
     */
    List<AdminExchangeCoinResDto> getAdminExchangeCoinResDtos(AdminExchangeCoinReqDto adminExchangeCoinReqDto);

    /**
     * 根据币种ID查找币种基础配置信息
     * @param adminExchangeCoinReqDto
     * @author yanping
     * @return
     */
    AdminExchangeCoinResDto getAdminCoinBase(AdminExchangeCoinReqDto adminExchangeCoinReqDto);

    /**
     * 修改交易所币种的基础信息
     * @param adminExchangeCoinBaseReqDto
     * @return
     */
    Integer updateExchCoinBase(AdminExchangeCoinBaseReqDto adminExchangeCoinBaseReqDto);

    /**
     * 根据币种ID查找币种详细信息
     * @param adminExchangeCoinReqDto
     * @author yanping
     * @return
     */
    AdminExchangeCoinDetailResDto getAdminCoinDetail(AdminExchangeCoinReqDto adminExchangeCoinReqDto);

    /**
     * 修改交易所币种信息
     * @param adminExchangeCoinDetailReqDto
     * @author yanping
     * @return
     */
    Integer updateExchCoinDetail(AdminExchangeCoinDetailReqDto adminExchangeCoinDetailReqDto);
}
