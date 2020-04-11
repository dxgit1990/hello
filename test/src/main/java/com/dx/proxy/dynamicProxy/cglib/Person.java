package com.dx.proxy.dynamicProxy.cglib;

/**
 * @author dx
 * @create 2020/4/12 2:05
 * @for test cglib proxy
 */
public class Person {

    public void say(){
        System.out.println("test cglib proxy method");
    }

    public static void staticMethod(){
        System.out.println("test cglib proxy static method");
    }
}
