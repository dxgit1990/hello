package com.els.timer;

import com.dx.pojo.User;
import com.els.pojo.Person;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTest {

	public static void main(String[] args) {
//		testTimer();
//		testPrint();
//		testNumber();
		testThread();

	}

	private static void testThread() {
		Person person = new Person();
		User user = new User();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (person) {
					System.err.println("锁住了person,等待user");
					try {
						Thread.currentThread().sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(user) {
						System.err.println("锁住了user");
					}
				}
				
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (user) {
					System.err.println("锁住了user,等待person");
					synchronized(person) {
						System.err.println("锁住了person");
					}
				}
				
			}
		}).start();
	}

	private static void testNumber() {
		AtomicInteger integer = new AtomicInteger();
		System.err.println(integer.intValue());
		integer.incrementAndGet();
		System.err.println(integer.intValue());
	}

	private static void testPrint() {
		String value = "i like kafka";
		System.err.println(value);
	}

	private static void testTimer() {
		Timer timer = new Timer("timer-test");
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.print("timer,halo.");
			}
		}, 1000);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		} finally {
			timer.cancel();
		}
	}
}
