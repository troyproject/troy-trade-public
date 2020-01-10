package com.troy.trade.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程工具类
 * @author xueqiang.wang
 * @version 1.0
 */
public class ThreadPoolUtils {

	private static Logger log = LoggerFactory.getLogger(ThreadPoolUtils.class);

    /** 线程池基本参数*/
    private static int corePoolSize = Runtime.getRuntime().availableProcessors(),
    		maxPoolSize = 60,keepAliveTime = 30,queueCapacity = 1000;


    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(queueCapacity),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void addProcess(Runnable runnable){
        try {
            threadPool.execute(runnable);
        } catch (Exception e) {
        	log.error("调用线程池的addProcess方法出错", e);
        }
    }

    public static <T> Future<T> addTask(Callable<T> task){
        return threadPool.submit(task);
    }

    public static <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks){
        try {
			return threadPool.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("调用线程池的invokeAll方法出错", e);
		}
        return null;
    }

    public static <T> T invokeAny(Collection<? extends Callable<T>> tasks){
        try {
			return threadPool.invokeAny(tasks);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("调用线程池的invokeAny方法出错", e);
		}
        return null;
    }



}
