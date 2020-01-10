package com.troy.trade.mapper.data;

import com.troy.commons.ext.support.mapper.BaseMapper;
import com.troy.trade.model.domain.data.TodamoonSourceModel;
import com.troy.trade.model.dto.in.data.TodamoonSourceReqDto;
import com.troy.trade.model.dto.out.data.TodamoonSourceDataResDto;

/**
 * todamoon数据操作Dao
 *
 * @author yanping
 */
public interface TodamoonSourceMapper extends BaseMapper<TodamoonSourceModel> {

    /**
     * 根据数据类型查询数据
     * @param todamoonSourceReqDto
     * @return
     */
    TodamoonSourceDataResDto getTodamoonSource(TodamoonSourceReqDto todamoonSourceReqDto);

    /**
     * 根据type删除数据
     * @param todamoonSourceReqDto
     * @return
     */
    int deleteByInfo(TodamoonSourceReqDto todamoonSourceReqDto);
}
