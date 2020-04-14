package com.els.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 测试atomic\volatile\synchronized类的可见性
 * 
 * @author dengxu
 *
 */

public class Test2 {
	AtomicBoolean flag = new AtomicBoolean();
//	/*volatile*/ boolean flag = false;

	void m() {
		System.err.println("flag值为start：" + flag.get());
//		System.err.println("flag值为start：" + flag);
		while (!flag.get()) {
//			while (!flag) {
//				synchronized (this) {
//					
//				}
		}
		System.err.println("flag值为end：" + flag.get());
//		System.err.println("flag值为end：" + flag);

	}

	public static void main(String[] args) throws InterruptedException {
		Test2 t = new Test2();

		new Thread(() -> t.m()).start();
		Thread.currentThread().sleep(2000);
		t.flag.set(true);
//		t.flag=true;
	}

}
