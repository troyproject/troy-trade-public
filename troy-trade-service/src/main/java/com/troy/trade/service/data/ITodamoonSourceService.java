package com.troy.trade.service.data;

import com.troy.commons.ext.support.service.IBaseService;
import com.troy.trade.exchange.api.model.dto.in.data.SyncTodamoonReqDto;
import com.troy.trade.model.domain.data.TodamoonSourceModel;
import com.troy.trade.model.dto.in.data.TodamoonSourceReqDto;
import com.troy.trade.model.dto.out.data.TodamoonSourceDataResDto;

/**
 * 服务接口
 *
 * @author yanping
 */
public interface ITodamoonSourceService extends IBaseService<TodamoonSourceModel> {


    /**
     * 根据数据类型查询数据
     * @param todamoonSourceReqDto
     * @return
     */
    TodamoonSourceDataResDto getTodamoonSource(TodamoonSourceReqDto todamoonSourceReqDto) throws Throwable;

    /**
     * 根据type删除数据
     * @param todamoonSourceReqDto
     * @return
     */
    int deleteByInfo(TodamoonSourceReqDto todamoonSourceReqDto) throws Throwable;

    /**
     * 根据参数操作数据，1、删除同类型数据、2、新增数据
     * @param syncTodamoonReqDto
     * @param todamoonSourceModel
     * @return
     * @throws Throwable
     */
    int operation(SyncTodamoonReqDto syncTodamoonReqDto, TodamoonSourceModel todamoonSourceModel) throws Throwable;
}
