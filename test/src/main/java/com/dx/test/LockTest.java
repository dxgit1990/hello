package com.dx.test;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dx
 * @create 2020/4/12 18:52
 * @for new
 */
public class LockTest {


    @Test
    public void testLatch() {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.countDown();
            latch.await();
            System.out.println("hi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReentrantlock() {
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
