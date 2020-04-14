package com.els.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test13 {
	static List<Integer> list = new ArrayList<Integer>();
	static final int num = 10;

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition producer = lock.newCondition();
		Condition consumer = lock.newCondition();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 3; i++) {
						lock.lock();
						while (list.size() == num) {
							try {
								producer.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						try {
							int nextInt = random.nextInt(10);
							list.add(nextInt);
//						Thread.sleep(1000);
							System.err.println(Thread.currentThread().getName() + " 生产了：" + nextInt);
							consumer.signalAll();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							lock.unlock();
						}
					}
				}
			}, "p" + i).start();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 5; i++) {
						lock.lock();
						while (list.size() == 0) {
							try {
								consumer.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						try {
							Integer remove = list.remove(0);
							System.err.println(Thread.currentThread().getName() + " 消费了：" + remove);
							producer.signalAll();
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							lock.unlock();
						}
					}
				}
			}, "c" + i).start();
		}

	}
}
