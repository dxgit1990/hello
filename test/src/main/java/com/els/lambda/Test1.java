package com.els.lambda;

import org.junit.Test;

public class Test1 {

	@Test
	public void print() {
//		System.err.println("hello");
		new Thread(() -> System.out.print(Thread.currentThread().getName())).start();
	}
	
	
}
