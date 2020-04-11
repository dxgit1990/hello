package com.dx.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dx
 * @create 2020/4/12 1:58
 * @for cglib proxy factory
 * cglib 是基于拦截器的实现机制，需要重写MethodInterceptor接口的intercept的方法
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //返回目标对象的代理对象
    public Object getProxyInstance(){
        //创建工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理开始");
        Object methodResult = method.invoke(target, args);
        System.out.println("cglib 代理完成");
        return methodResult;
    }
}
