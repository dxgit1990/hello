package com.els.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Test12 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		AtomicInteger num=new AtomicInteger();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				while(true) {
				System.out.println(System.currentTimeMillis());
				num.incrementAndGet();
				if(num.get() ==5) {
					break;
				}
				}
			}
		}, 3000,5000);
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(num.get()==5) {
			timer.cancel();
			break;
		}
		System.err.println("");
//		timer.cancel();
	}
}
