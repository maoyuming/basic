package com.duantuke.basic.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.duantuke.basic.service.impl.SightSearchServiceImpl;

public class ThreadPoolUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SightSearchServiceImpl.class);
	
	public static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	/**
     * 线程队列的最大长度
     */
    public static int MAX_LENGTH = 2000;

    /**
     * 线程池的保存线程数
     */
    public static int corePoolSize = 20;

    /**
     * 最大线程数
     */
    public static int maximumPoolSize = 30;

    /**
     * 超过规模线程最大存活时间
     */
    public static long keepAliveTime = 1L;


    /**
     * 线程最大等待时间
     */
    public static int timeout = 10;

    /**
     * 线程休眠时间
     */
    public static long threadSleep = 50;
    
    public static void threadSleep(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            logger.error("线程中断异常", e);
        }
    }
}
