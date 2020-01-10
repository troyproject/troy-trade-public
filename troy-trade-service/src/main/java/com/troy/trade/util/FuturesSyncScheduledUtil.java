package com.troy.trade.util;

import com.troy.trade.constant.SyncConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 合约同步相关
 */
@Slf4j
@Component
public class FuturesSyncScheduledUtil {

    @Autowired
    SyncConfig syncConfig;

    /**
     * 合约信息同步处理
     */
    public void syncContractInfo(Integer clearType){

//        String syncTemp = "";
//        try {
//            if (clearType == ScheduledConstant.SYNC_SAVE_TYPE_MANUAL) {
//                syncTemp = "手动同步全量ticker信息";
//            } else if (clearType == ScheduledConstant.SYNC_SAVE_TYPE_SYS) {
//                syncTemp = "自动同步全量ticker信息";
//            }
//
//            /**
//             * 交易对信息同步标记是否放开
//             */
//            if (!syncConfig.isAllTicker()) {
//                String temp = syncTemp + "：交易所全量ticker信息同步标记未放开，请在参数中放开,修改参数 sync:allTicker 为 true。当前时间：" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME);
//                log.warn(temp);
//                return;
//            }
//
//            /**
//             * 做交易对信息同步中处理
//             */
//            //sync:allTicker:incr
//            String syncSymbolIncrKey = ScheduledConstant.SYNC_ALL_TICKER_INCR_REDIS_KEY;
//            if (1 == redisUtil.increment(syncSymbolIncrKey)) {
//                redisUtil.expire(syncSymbolIncrKey, ScheduledConstant.SYNC_ALL_TICKER_TIME_OUT, TimeUnit.MINUTES);
//            } else {
//                String temp = syncTemp + "：当前正在同步交易所全量ticker信息，请稍后再试。当前时间：" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME);
//                log.info(temp);
//                return;
//            }
//
//            //sync:allTicker:exchCode
//            String allTickerMapRedisKey = ScheduledConstant.SYNC_ALL_TICKER_EXCHCODE_MAP_REDIS_KEY;
//
//            /**
//             * 查找所有交易所
//             */
//            List<ExchangeCodeResDto> exchangeCodeResDtoList = exchangeService.getExchCode();
//            int size = exchangeCodeResDtoList == null ? 0 : exchangeCodeResDtoList.size();
//            for (int i = 0; i < size; i++) {
//                //Integer index, Integer total, Integer clearType, String allTickerMapRedisKey, ExchangeCodeResDto exchangeCodeResDto
//                AllTickersSyncExecute allTickersSyncExecute = AllTickersSyncExecute.getInstance((i + 1), size, clearType, allTickerMapRedisKey, exchangeCodeResDtoList.get(i));
//                SyncThreadPool.executeAllTickersSync(allTickersSyncExecute);
//            }
//
//            int count = 0;
//            Long length = redisUtil.hlen(allTickerMapRedisKey);
//            while (length < size && count < 99) {
//                log.info(syncTemp + "：当前第" + count + "轮检查是否同步完成");
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                length = redisUtil.hlen(allTickerMapRedisKey);
//                count++;
//            }
//
//            log.info(syncTemp + "：同步结束，当前时间" + DateUtils.formatDate(new Date(), DateUtils.FORMAT_DATE_TIME)
//                    + ",本次将要同步的交易所为:" + objectMapper.writeValueAsString(exchangeCodeResDtoList));
//            redisUtil.removePattern(ScheduledConstant.SYNC_ALL_TICKER_REDIS_KEY_PREFIX + "*");
//        } catch (Throwable throwable) {
//            log.error(syncTemp + "：做交易所全量ticker列表同步处理，异常，异常信息：", throwable);
//            redisUtil.removePattern(ScheduledConstant.SYNC_ALL_TICKER_REDIS_KEY_PREFIX + "*");
//        }

    }
}
