package com.dx.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dx
 * @create 2020/4/12 18:52
 * @for new
 */
public class LockTest {

    public static void main(String[] args) {
//        testReentrantlock();
        testLatch();
    }

    private static void testLatch() {
        CountDownLatch latch = new CountDownLatch(5);
        try {
            latch.await();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testReentrantlock() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            condition.signal();
        }

    }
}
