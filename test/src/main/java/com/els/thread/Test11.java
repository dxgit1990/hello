package com.els.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test11 {
//	static List<Integer> list =new Vector<Integer>();
	static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();

//	static ConcurrentLinkedQueue<Integer> queue =new ConcurrentLinkedQueue<>();
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				for (int j = 0; j < 10000; j++) {
					list.add(j);
//					queue.add(j);
//					queue.offer(j);
				}
			}).start();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(list.size());
	}
}
