package com.els.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import com.sun.accessibility.internal.resources.accessibility;

import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 * 查看concurrentHashMap远吗
 * 
 * @author dengxu
 *
 */
public class Test6 {
	public static void main(String[] args) throws InterruptedException {
//		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//
//		Map<String, String> hashMap = new HashMap<>();
//		Map<String, String> synchronizedMap = Collections.synchronizedMap(hashMap);
//		synchronizedMap.put("", "");
		List<String> list =new ArrayList<>();
		list.add("");
		testArrs();
		TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
		transferQueue.transfer("ab");
//		ArrayBlockingQueue<E>
	}

	private static void testArrs() {
		String a[] = new String[5];
		a[0] = "zhang";
		a[2] = "li";
		a[4] = "zhao";
		List<String> asList = Arrays.asList(a);
		for (String string : asList) {
			System.err.println(string);
		}
	}
}
