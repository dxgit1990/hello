package com.dx.test;

/**
 * @author dx
 * @create 2020/4/9 12:44
 * @for new
 */
public class Test3 {
    public static void main(String[] args) {
        test(1);
//        test2(1);
    }

    public static void test(int start) {
        if (start <= 3) {
            test(start++);
            System.out.println(start);
        }
    }

    public static void test2(int start) {
        if (start <= 3) {
            test2(++start);
            System.out.println(start);
        }
    }
}
