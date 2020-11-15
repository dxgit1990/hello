package com.dx.thread;

/**
 * @author dx
 * @create 2020/10/1 7:27
 * @for new
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup());
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a child thread");
            }
        };
        Thread thread = new Thread(r1);
        System.out.println("th = " + thread.getThreadGroup());

    }
}
