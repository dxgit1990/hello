package com.els.thread;

/**
 * 测试volatile
 * 
 * @author dengxu
 *
 */
public class Test4 {
	volatile int flag = 5;

	void exec() {
		while (flag == 5) {
			System.err.println(Thread.currentThread().getName() + "线程：  exec task...");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		Test4 t = new Test4();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() + "启动");
				t.exec();
				System.err.println(Thread.currentThread().getName() + "结束");
			}
		}, "t1").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() + "启动");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				t.flag = 3;
				System.err.println(Thread.currentThread().getName()+"结束");	
			}
		}, "t2").start();

	}
}
