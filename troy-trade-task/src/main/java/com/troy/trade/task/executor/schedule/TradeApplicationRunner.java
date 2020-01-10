package com.troy.trade.task.executor.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 初始化订单同步任务
 *
 * @author
 */
@Slf4j
@Component
@Order(value = 1)
public class TradeApplicationRunner implements ApplicationRunner {

    @Autowired
    private SyncOrderInfoScheduledUtil syncOrderInfoScheduledUtil;


    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("初始化订单同步任务");
        syncOrderInfoScheduledUtil.initScheduler();
    }

}
