package com.troy.trade.mapper.order;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.api.model.dto.out.exchange.NetworkExportResDto;
import com.troy.trade.model.domain.order.NetworkExportModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NetworkExportModel
 */

@Repository
public interface NetworkExportMapper extends BaseMapper<NetworkExportModel> {


    List<NetworkExportResDto> queryAllNetworkExport();


}
