package com.dx.test;

import com.dx.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dx
 * @create 2020/4/9 16:30
 * @for new
 */
public class Test4 {
    public static void main(String[] args) {
//        testClass();
//        getConstructor();
//        getFiled();
        getMethod();
    }

    private static void getMethod() {
        User user = new User();
        Class clazz = user.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        try {
            User o = (User) clazz.newInstance();
            o.setName("tom");
            Method getName = clazz.getMethod("getName");
            Object lucy = getName.invoke(o);
            System.out.println(lucy);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void getFiled() {
        try {
            Class<?> clazz = Class.forName("com.dx.pojo.User");
//            Field[] fields = clazz.getFields();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("field = " + field.getName());
            }
            try {
                Object o = clazz.getConstructor().newInstance();
                Field field = clazz.getDeclaredField("name");
                field.setAccessible(true);
                field.set(o, "lucy");
                System.out.println(o);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getConstructor() {
        Class<User> userClass = User.class;
//        Constructor<?>[] constructors = userClass.getConstructors();
        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        try {
            Constructor<User> constructor = userClass.getDeclaredConstructor(String.class, String.class);
            System.out.println("constructor = " + constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //根据user的类对象
        try {
            User user = userClass.newInstance();
            System.out.println("user = " + user);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void testClass() {
        System.out.println(User.class);
        try {
            System.out.println(Class.forName("com.dx.pojo.User"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user = new User();
        System.out.println(user.getClass());

    }
}
