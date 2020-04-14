package com.els.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Test1 {
	volatile static boolean flag = true;

	public static void main(String[] args) {
//		testsort();
//		testThread();
//		testjoin();
//		testvolatile();

	}

	private static void testvolatile() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (flag) {
					System.err.println(Thread.currentThread().getName() + " execute task^&");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.err.println(Thread.currentThread().getName() + " 线程 stop");
			}
		}, "t1").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = false;
				System.err.println(Thread.currentThread().getName() + " 线程 stop");
			}
		}, "t2").start();

	}

	private static void testjoin() {
		CountDownLatch latch = new CountDownLatch(1);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.err.println(name + "线程启动");
				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println(name + " exec task ……");
				System.err.println(name + "线程结束");
			}
		}, "t2");
		t.start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.err.println(name + "线程启动");
				System.err.println(name + " exec task ……");
				try {
					Thread.currentThread().sleep(2000);
					latch.countDown();
					Thread.currentThread().sleep(2000);
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println(name + "线程结束");
			}
		}, "t1").start();

	}

	private static void testThread() {
//		Test1 t1 =new Test1();
//		test t =t1.new test();
//		t.start();
		test t2 = new test();
		t2.start();
	}

	static class test extends Thread {

		@Override
		public void run() {
			System.err.println("test thread");
		}

	}

	private static void testsort() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(7);
		list.add(53);
		list.add(24);
		list.add(15);
		Collections.sort(list, (a, b) -> {
//			if (a == b) {
//				return 0;
//			}
			return b > a ? 1 : -1;
		});
		list.stream().forEach(n -> System.err.println(n));
	}
}
