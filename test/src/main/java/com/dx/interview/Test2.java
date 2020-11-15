package com.dx.interview;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dx
 * @create 2020/11/5 20:30
 * @for new
 */
public class Test2 {

    public synchronized void test1(){
        try {
            System.out.println("test1 start");
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        System.out.println("test1 end");
    }

    public void test2(){
        System.out.println("test method execute……");
    }

//    public static void main(String[] args) {
//        Test2 t = new Test2();
//        new Thread(()->t.test1()).start();
//        new Thread(()->t.test2()).start();
//    }

    @Test
    public void testArrays(){
        int[] ids = {11,13,19,7,21};

//        List<int[]> ints = Arrays.asList(ids);
//        ints.set(1, new int[]{12});
        System.out.println("ids = " + ids);
    }
}
