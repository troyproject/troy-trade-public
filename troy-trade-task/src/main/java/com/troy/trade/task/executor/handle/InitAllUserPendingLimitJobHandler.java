package com.troy.trade.task.executor.handle;

import com.troy.redis.RedisUtil;
import com.troy.task.core.biz.model.ReturnT;
import com.troy.task.core.handler.IJobHandler;
import com.troy.task.core.handler.annotation.JobHandler;
import com.troy.trade.constant.Constant;
import com.troy.trade.model.dto.in.SpotTransLimitReqDto;
import com.troy.trade.model.dto.out.SpotTransLimitResDto;
import com.troy.trade.service.ISpotTransPendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 每10分钟初始化一次用户的挂单数
 *
 * @author dp
 */
@Slf4j
@JobHandler(value="initAllUserPendingLimit")
@Component
public class InitAllUserPendingLimitJobHandler extends IJobHandler {

    @Autowired
    private ISpotTransPendingService spotTransPendingService;

    @Autowired
    private RedisUtil redisUtil;

    // fixedDelay = 10 * 60 * 1000
    // 0 0/10 * * * ?
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        List<SpotTransLimitResDto> spotTransLimitResDtos = spotTransPendingService.querySpotTransLimit(new SpotTransLimitReqDto());
        if (CollectionUtils.isEmpty(spotTransLimitResDtos)) {
            redisUtil.hDelAll(Constant.SPOT_PENDING_LIMIT_TABLE);
        } else {
            redisUtil.hDelAll(Constant.SPOT_PENDING_LIMIT_TABLE);
            spotTransLimitResDtos.stream().forEach(spotTransLimitResDto -> redisUtil.hset(Constant.SPOT_PENDING_LIMIT_TABLE, Constant.getSpotPendingLimitKey(spotTransLimitResDto.getUserId(), spotTransLimitResDto.getExchCode()), spotTransLimitResDto.getCountNum() + ""));
        }
        return SUCCESS;
    }
}
