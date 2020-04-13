package com.dx.test;

/**
 * @author dx
 * @create 2020/4/12 17:56
 * @for new
 */
public class ServiceTest<T> {
    private T obj;

    public ServiceTest(T obj) {
        this.obj = obj;
    }

    public ServiceTest() {
    }

    public Class getClazz(){
        return obj.getClass();
    }

}
