package com.els.thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test15 {
	public static void main(String[] args) {
		LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						int nextInt = new Random().nextInt(5);
						try {
							queue.put(nextInt);
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.err.println(Thread.currentThread().getName() + "生产了：" + nextInt);
					}
				}
			}, "p" + i).start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						Integer poll = null;
						try {
							poll = queue.take();
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.err.println(Thread.currentThread().getName() + "消费了：" + poll);
					}
				}
			}, "c" + i).start();
		}
	}
}
