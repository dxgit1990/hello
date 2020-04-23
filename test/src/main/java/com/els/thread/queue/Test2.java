package com.els.thread.queue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dx
 * @create 2020/4/23 19:17
 * @for new
 * 基于队列的生产者消费者模型
 */
public class Test2 {
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    public void add() {
        try {
            while (true) {
                int i = new Random().nextInt(10);
                queue.put(i);
                System.out.println(Thread.currentThread().getName()+"生产了一个数据" + i);
                Thread.currentThread().sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get() {
        try {
            while (true) {
                Integer poll = queue.take();
                if (poll == null) {
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"消费了一个数据" + poll);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        for (int i = 0; i < 6; i++) {
            new Thread(test::add,"p"+i).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(test::get,"tc"+i).start();
        }
    }
}
