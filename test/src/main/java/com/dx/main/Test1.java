package com.dx.main;

/**
 * @author dx
 * @create 2020/11/25 0:04
 * @for new
 */
public class Test1 {
    private static volatile int num=0;

    public static void main(String[] args) throws Exception {
        new Thread(()->{
            while(num==0){

            }
        }).start();
        Thread.sleep(1000);
        num=1;
        System.out.println("main thread");
    }
}
