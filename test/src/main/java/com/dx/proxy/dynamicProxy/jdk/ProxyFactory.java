package com.dx.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dx
 * @create 2020/4/12 1:05
 * @for proxy factory
 */
public class ProxyFactory {
    private Object target;//目标对象

    //目标对象初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //获取目标对象的代理对象
    public Object getProxyInstance() {
        /**
         * public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         * ClassLoader loader       指定当前目标对象的类加载器，获取加载器的方法固定
         * Class<?>[] interfaces    目标对象实现的接口类型，使用泛型方法确认类型
         * InvocationHandler h      事件处理，执行目标对象的方法时，会触发事件处理器的方法，
         *                          会把当前执行的目标对象方法作为参数传入
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk 动态代理 执行。。。");
                Object methodReslut = method.invoke(target, args);
                System.out.println("jdk 动态代理 执行完毕。。。");
                return methodReslut;
            }
        });
//        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (Object proxy, Method method, Object[] args) -> {
//                    System.out.println("jdk 动态代理 执行。。。");
//                    Object methodReslut = method.invoke(target, args);
//                    return methodReslut;
//                }
//        );
    }

}
