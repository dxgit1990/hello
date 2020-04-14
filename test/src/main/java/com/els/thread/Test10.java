package com.els.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * forkjoinpool
 * 
 * @author dengxu
 *
 */
public class Test10 {
	static List<Long> list = new ArrayList<Long>();
	static Random random = new Random();
	static {
		for (int i = 0; i <100000000; i++) {
			list.add(Long.valueOf(i + random.nextInt(1000)));
		}
	}

	public static void main(String[] args) {
//		Test10 t = new Test10();
		System.err.println(list.size());
		long ctime=System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		long etime=System.currentTimeMillis();
		System.err.println(sum);
		System.err.println(etime-ctime);
		ForkJoinPool pool = new ForkJoinPool();
		MyTask task = /*t.*/new MyTask(0, list.size());
		pool.execute(task);
		System.err.println(task.join());
		long ptime=System.currentTimeMillis();
		System.err.println(ptime-etime);

	}

	static class MyTask extends RecursiveTask<Long> {
		Integer start, end;
		MyTask(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			long sum = 0;
			if (end - start <= 50000) {
				for (int i = start; i < end; i++) {
					sum = sum + list.get(i);
				}
				return sum;
			} else {
				Integer middle = start + (end - start) / 2;
				MyTask task1 = new MyTask(start, middle);
				MyTask task2 = new MyTask(middle, end);
				task1.fork();
				task2.fork();
				return task1.join() + task2.join();
			}
		}

	}
}
