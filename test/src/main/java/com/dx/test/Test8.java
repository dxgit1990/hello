package com.dx.test;

import java.math.BigInteger;

/**
 * @author dx
 * @create 2020/4/15 16:50
 * @for test Array
 */
public class Test8 {
    public static void main(String[] args) {
//        bigIntegerTest();
        testClazz();
        testArray();

    }

    /**
     * arrays.copyof
     * arrays.sort
     * arrays.parallelsort
     * arrays.binarySearch
     * arrays.tostring
     */
    private static void testArray() {

    }

    private static void testClazz() {
        int []a=new int[5];
        byte [] b = new byte[]{};
        String [] str = new String[]{"s"};
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(str.getClass().getName());
    }

    private static void bigIntegerTest() {
        BigInteger integer = new BigInteger("5");
        BigInteger add = integer.add(new BigInteger("3"));
        System.out.println("add = " + add);
        System.out.println(integer.compareTo(new BigInteger("5")));
        System.out.println(integer.intValue());
        System.out.println(integer.bitCount());
    }
}
