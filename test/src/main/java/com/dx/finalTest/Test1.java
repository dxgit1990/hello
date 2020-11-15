package com.dx.finalTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author dx
 * @create 2020/10/12 5:46
 * @for new
 */
public class Test1 {
    static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                synchronized (Test1.class) {
                    String str = "test" + new
                            Random().nextInt(5);
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "==>" + str);
                    list.add(str);
//                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);


        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("list = " + list);
    }
}
