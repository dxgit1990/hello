package com.dx.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello,idea.");
//        test();
//        testLinkedList();
//        testLocalTime();
//        testfor();
//        test2();
//        testadd();
//        testToArray();
//        testNumber();
//        testAdd();
//        testHashSet();
//        testInt();
        testLock();

    }

    private static void testLock() {
        Object object1 = new Object();
        Object object2 = new Object();
        new Thread(() -> {
            synchronized (object1) {
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("test1 process task ……");
                }
            }
        }, "test1").start();
        new Thread(() -> {
            synchronized (object2) {
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("test2 process task ……");
                }
            }
        }, "test2").start();
    }

    private static void testInt() {
        Integer a = 300;
        Integer b = 300;
        System.out.println(a == b);
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

    private static void testHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("hallo");
        set.add(null);
        System.out.println(set.toString());
        int value = (int) (5 / .75f) + 1;
        System.out.println("value = " + value);

    }

    private static void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("test");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }


    private static void testAdd() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(33);
        list.add(13);
        list.add(73);
        List<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(12);
        list2.add(22);
        list2.add(32);
        list2.add(42);
        list.addAll(3, list2);
        System.out.println("list = " + list);
        List<Integer> integers = list.subList(2, 5);
        System.out.println("integers = " + integers);
    }


    private static void testNumber() {
        double num = 5000;
//        Double aDouble = new Double();
        BigDecimal bigDecimal = new BigDecimal(num);
        System.out.println(Long.MIN_VALUE);


    }

    private static void testToArray() {
        int[] num = {1, 2, 3, 4};
        List<Integer> list = new ArrayList<>();
        list.add(11);
        Object[] ts = list.toArray();
        Arrays.asList(ts).forEach(System.out::print);
    }


    private static void testadd() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(list2);
        System.out.println("list = " + list);

    }

    private static void test2() {
        System.out.println("hello,git!");
    }


    private static void testfor() {
        System.out.println(LocalTime.now());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(5));
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


    /**
     *
     */
    private static void testLocalTime() {

//        LocalTime time = LocalTime.time();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss SSS");
        StringBuffer sb = new StringBuffer();
        System.out.println(time.format(formatter));
        System.out.println(time.getDayOfYear());

    }

    private static void test() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bbb");
        list.add("dddd");
        list.stream().filter(s -> s.length() > 3).forEach(System.out::print);
    }

}
