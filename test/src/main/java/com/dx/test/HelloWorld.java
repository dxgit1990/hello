package com.dx.test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello,idea.");
//        test();

//        testLocalTime();
        testfor();
//        test2();
    }

    private static void test2() {
        System.out.println("hello,git!");
    }


    private static void testfor() {
        System.out.println(LocalTime.now());
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(5));
        }
        for (Integer integer:list){
            System.out.println(integer);
        }
    }


    /**
     *
     */
    private static void testLocalTime() {

//        LocalTime time = LocalTime.time();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss SSS");
        StringBuffer sb = new StringBuffer();
        System.out.println(time.format(formatter));
        System.out.println(time.getDayOfYear());

    }

    private static void test() {
        List<String> list =new ArrayList<>();
        list.add("abc");
        list.add("bbb");
        list.add("dddd");
        list.stream().filter(s -> s.length()>3).forEach(System.out::print);
    }

}
