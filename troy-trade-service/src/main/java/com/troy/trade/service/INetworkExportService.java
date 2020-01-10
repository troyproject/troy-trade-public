package com.troy.trade.service;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.api.model.dto.in.exchange.admin.AdminNetworkExportReqDto;
import com.troy.trade.api.model.dto.out.exchange.NetworkExportResDto;
import com.troy.trade.model.domain.order.NetworkExportModel;

import java.util.List;

/**
 * 网络出口服务
 *
 * @author dp
 */
public interface INetworkExportService extends IBaseService<NetworkExportModel> {

     int updateNetworkHostUser(AdminNetworkExportReqDto reqDto);

     int addNetworkHostUser(AdminNetworkExportReqDto reqDto);

     List<NetworkExportResDto> queryAllNetworkExport();

     List<String> getExportIps();
}
