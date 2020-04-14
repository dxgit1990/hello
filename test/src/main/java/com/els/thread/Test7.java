package com.els.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/**
 * executor executorservice
 * 
 * @author dengxu
 *
 */
public class Test7 {
	public static void main(String[] args) {
//		Executor
//		Callable<V>
		// 获取cpu个数
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.err.println(availableProcessors);

		StringBuffer sBuffer = new StringBuffer();
		StringBuilder sBuilder = new StringBuilder();
	}
}
