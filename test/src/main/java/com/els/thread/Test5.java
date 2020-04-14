package com.els.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试reentrantlock 可重入锁
 * 
 * @author dengxu
 *
 */
public class Test5 {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		try {
			condition.await();
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
