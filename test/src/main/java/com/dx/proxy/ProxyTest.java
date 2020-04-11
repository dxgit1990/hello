package com.dx.proxy;

import com.dx.proxy.common.IteacherDao;
import com.dx.proxy.common.TeacherDao;
import com.dx.proxy.dynamicProxy.cglib.CglibProxyFactory;
import com.dx.proxy.dynamicProxy.cglib.Person;
import com.dx.proxy.dynamicProxy.jdk.ProxyFactory;
import com.dx.proxy.staticProxy.TeacherDaoProxy;
import org.junit.Test;

/**
 * @author dx
 * @create 2020/4/12 0:07
 * @for 代理模式测试
 */
public class ProxyTest {

    /**
     * cglib代理测试
     * 被代理的类不能是final类
     * 目标对象的方法如果是final或static，则不会被拦截，也不执行目标对象额外的业务逻辑
     */
    @Test
    public void testCglibProxy(){
        Person person = new Person();
        Person proxy = (Person)new CglibProxyFactory(person).getProxyInstance();
        proxy.say();
    }


    /**
     * jdk动态代理
     */
    @Test
    public void testJdkDynamicProxy(){
        TeacherDao teacherDao = new TeacherDao();
        IteacherDao proxy = (IteacherDao) new ProxyFactory(teacherDao).getProxyInstance();
//        System.out.println("proxy = " + proxy);   //代理对象的所有方法均会被proxyfactory代理
        System.out.println("proxy.getClass() = " + proxy.getClass());//以$开头的就是在内存中生成的代理对象

        proxy.tellKnowledge();
    }

    //测试静态代理
    @Test
    public void test1() {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);
        proxy.tellKnowledge();
    }
}
