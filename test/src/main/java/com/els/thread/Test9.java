package com.els.thread;
/**
 * 
 * @author dengxu
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test9 {
//	volatile static boolean flag = true;

	public static void main(String[] args) {
//		testConcurrentLinkedQueue();
//		testLinkedBlockingQueue();
//		testArrayBlockingQueue();
		testdeleyQueue();

	}

	private static void testdeleyQueue() {
		BlockingQueue<MyTask> queue = new DelayQueue<>();//无界队列,该队列的任务必须实现delayed接口
		
	}

	private static void testArrayBlockingQueue() {//有界队列
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		new Thread(() -> {
			for (int i = 0;; i++) {
				try {
					queue.put(String.valueOf(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			System.err.println(queue);
		}, "producer").start();
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				String take = null;
				while (true) {
					try {
						take = queue.take();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println(Thread.currentThread().getName() + "take value: " + take);
				}

			}, "consumer" + i).start();
		}
		System.err.println(queue.size());
	}

	private static void testConcurrentLinkedQueue() {//并发队列
		Queue<String> queue = new ConcurrentLinkedQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.offer("test" + i);
		}

		System.err.println("长度" + queue.size() + " ,content: " + queue);
		System.err.println(queue.poll());
		System.err.println(queue.size());
		System.err.println(queue.peek());
		System.err.println(queue.size());

	}

	private static void testLinkedBlockingQueue() {//无界队列
		LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				for (int i = 0; i < 20; i++) {
					try {
						queue.put("lucy" + i);
						System.err.println(Thread.currentThread().getName() + "放入了一个值：lucy" + i);
						Thread.currentThread().sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "producer").start();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				String poll = null;
				while (true) {
					try {
//						poll = queue.take();
						Thread.currentThread().sleep(500);
						poll = queue.poll();
						if (poll == null) {
							break;
						}
					} catch (Exception e) {
						Thread.currentThread().interrupt();
						break;
					}
					System.err.println("线程：" + name + " take value :" + poll + " ,size: " + queue.size());
				}
			}
		}, "consumer");
		t2.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		flag = false;
//		t2.interrupt();
	}
	
	static class  MyTask implements Delayed{

		@Override
		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
