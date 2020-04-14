package com.els.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test14 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		ReentrantLock lock = new ReentrantLock();
		Condition p = lock.newCondition();
		Condition c = lock.newCondition();
//		Random random = new Random();
		AtomicInteger num = new AtomicInteger();
		int max = 30;
		AtomicBoolean flag = new AtomicBoolean();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (num.get() == max) {
						flag.set(true);
						break;
					}
					lock.lock();
					while (list.size() == 1) {
						try {
							p.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						int incrementAndGet = num.incrementAndGet();
						list.add(incrementAndGet);
						Thread.sleep(1000);
						System.err.println(Thread.currentThread().getName() + " 生产了： " + incrementAndGet);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						c.signalAll();
						lock.unlock();
					}
				}
			}
		}, "p").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!flag.get()) {
					lock.lock();
					while (list.size() == 0) {
						try {
							c.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						Integer remove = list.remove(0);
						Thread.sleep(1000);
						System.err.println(Thread.currentThread().getName() + " 消费了： " + remove);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						p.signalAll();
						lock.unlock();
					}
				}
			}
		}, "c").start();
	}
}
