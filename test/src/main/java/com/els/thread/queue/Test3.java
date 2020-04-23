package com.els.thread.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dx
 * @create 2020/4/23 19:34
 * @for new
 */
public class Test3 {

    public List<Integer> list = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition produce = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            while (true) {
                while (list.size() == 10) {
                    produce.await();
                }
                int i = new Random().nextInt(100);
                list.add(i);
                System.out.println(Thread.currentThread().getName() + "生产了一个数据： " + i);
                consumer.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    public void get() {
        lock.lock();
        try {
            while (true) {
                while (list.size() == 0) {
                    consumer.await();
                }
                Thread.sleep(500);
                Integer integer = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费了一个数据： " + integer);
                produce.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Test3 test = new Test3();

        for (int i = 0; i < 5; i++) {
            new Thread(test::get,"c"+i).start();
        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(test::add, "p" + i).start();
//        }


    }

}
