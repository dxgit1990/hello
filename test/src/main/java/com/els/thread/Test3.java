package com.els.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 测试门闩 countdownlatch
 * 
 * @author dengxu
 *
 */
public class Test3 {

	List list = new ArrayList<>();

	void set(Object e) {
		list.add(e);
	}

	int size() {
		return list.size();
	}

	public static void main(String[] args) {
		Test3 t = new Test3();
		CountDownLatch latch = new CountDownLatch(1);
		new Thread(new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.err.println(name + "启动");
				if (t.size() != 5) {
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.err.println(name + "结束");
			}
		}, "t2").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.err.println(name + "启动");
				for (int i = 0; i < 10; i++) {
					t.set(new Object());
					System.err.println("add"+(i+1));
					if (t.size() == 5) {
						latch.countDown();
					}
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.err.println(name + "结束");
			}
		}, "t1").start();
	}

}
