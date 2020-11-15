package com.dx.test;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dx
 * @create 2020/7/1 14:50
 * @for new
 * 造数 一千万数据
 */
public class TestMakeNum {

    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    @Test
    public void makeNum(){

        long start = System.currentTimeMillis();
        Random random= new Random();
        for (int i = 0; i < 10000000; i++) {
            try {
                queue.put(random.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(queue.size());
        System.out.println("cost time = " + (end-start)/1000);
    }
}
