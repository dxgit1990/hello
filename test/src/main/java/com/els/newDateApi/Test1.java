package com.els.newDateApi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test1 {
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();

	}

	/**
	 * 时间矫正器 TemporalAdjusters
	 */
	private static void test3() {
//		TemporalAdjusters
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
		System.err.println(now.format(formatter));
	}

	/**
	 * Instant 获取毫秒数 从1970年1月1日 零时零分零秒开始开始计算
	 */
	private static void test2() {
		Instant start = Instant.now();
		Instant end = Instant.now();
		System.err.println(Duration.between(start, end).toMillis());
	}

	private static void test1() {
		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
		System.err.println(now.format(formatter));
		System.err.println(LocalTime.NOON);
		System.err.println(LocalTime.MAX.getSecond());
		LocalTime localTime = LocalTime.of(16, 21);
		System.err.println(localTime);
		LocalTime plusHours = now.plusHours(1);
		System.err.println(plusHours.format(formatter));
	}
}
