package com.els.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * threadpool
 * @author dengxu
 *
 */
public class Test8 {
	public static void main(String[] args) {
		ExecutorService threadPool = null;
		try {
//			threadPool = Executors.newFixedThreadPool(5);//固定线程池
//			threadPool=Executors.newCachedThreadPool();//弹性线程池
//			threadPool=Executors.newSingleThreadExecutor();//单个线程 保证执行书序
//			threadPool=Executors.newScheduledThreadPool(4);//定时任务线程池，默认线程数为cpu核数 
			threadPool=Executors.newWorkStealingPool();//底层forkjoinpool 抢任务
			/**
			 * 大数据类计算
			 * RecursiveAction forkjointask实现类 不返回结果
			 *  RecursiveTask  forkjointask实现类 返回结果
			 */
			ForkJoinPool joinPool = new ForkJoinPool();
			RecursiveTask<Long> recursiveTask = new RecursiveTask<Long>() {

				@Override
				protected Long compute() {
					
					return null;
				}
			};
			joinPool.execute(recursiveTask);
			Long join = recursiveTask.join();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
