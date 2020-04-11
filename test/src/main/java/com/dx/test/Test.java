package com.dx.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dengx
 * @date 2020/3/20-12:52
 * @for test plus double
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("test plus DOUBLE file header.");
//        plus(5,6);
//        testLambda();
        testPrint("this is a paramter");
//        System.out.println("args = " + args);
//        System.out.println("args = [" + args + "]");
//        System.out.println(5>>1);
//        System.out.println(5%2);
        String string = "abc";
        String string1 = "def";
        System.out.println(string.concat(string1));
    }

    private static void testPrint(String str) {
        List<String> list =new ArrayList<>();
        System.out.println(list.size());
        System.out.println("list = " + list);
        AtomicInteger integer = new AtomicInteger();
        System.out.println("integer = " + integer);
    }

    private static void testLambda() {
        Arrays.asList("abc","cde","efg")
                .stream().map(s -> s.toUpperCase()).forEach(System.out::print);
        String reduce = Arrays.asList("abc", "cde", "efg")
                .stream().map(s -> s.toUpperCase()).reduce("", (x,y)->x+y);
        System.out.println("reduce = " + reduce);
    }


    public static void plus(double num1,double num2){
        System.out.println(num1+num2);
    }
}
