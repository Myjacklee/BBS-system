package com.nuist.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiZonggen
 * @date 2021-03-14 18:38
 * @description:线程池测试
 * @version:
 */
public class ThreadPool {
    ThreadPoolExecutor a=new ThreadPoolExecutor(3,5,1L,TimeUnit.SECONDS,new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
}
