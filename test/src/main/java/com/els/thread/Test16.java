package com.els.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Test16 {
	@Test
	public void testName() {
		ExecutorService service = Executors.newCachedThreadPool();
		Random random = new Random();
		random.nextInt();
		int i = (int) Math.random() * 10;
		for (int j = 0; j < 5; j++) {
			new Thread(() -> System.err.println(Thread.currentThread().getName()), "test" + j).start();
		}

	}

	@Test
	public void testName2() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(),
				new ThreadFactory() {

					@Override
					public Thread newThread(Runnable r) {
						return new Thread(r, "test-thread-name");
					}
				});
		executor.execute(new Thread(() -> System.err.println(Thread.currentThread().getName())));
	}
}
