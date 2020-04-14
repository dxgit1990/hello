package com.els.thread;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 验证atomic类原子性 十个线程均+1000  运行结果是一万
 * @author dengxu
 *
 */
public class Test1 {
	/* volatile */ AtomicInteger num = new AtomicInteger();
//	int num=0;

	/*synchronized*/ void m() {
		for (int i = 0; i < 1000; i++) {
			num.incrementAndGet();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Test1 test1 = new Test1();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					test1.m();
				}
			}).start();
		}
		Thread.currentThread().sleep(1000);
		System.err.println(test1.num.intValue());
//		System.err.println(test1.num);

	}
}
