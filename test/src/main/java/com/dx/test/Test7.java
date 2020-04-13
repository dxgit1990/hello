package com.dx.test;

import com.dx.pojo.Apple;
import org.junit.Test;

/**
 * @author dx
 * @create 2020/4/14 1:25
 * @for test object copy clone
 */
public class Test7 {

    @Test
    public void test1(){
        Apple.Fruit fruit = new Apple.Fruit("hot");
        Apple apple = new Apple("red",fruit);
        Apple clone = apple.clone();
        System.out.println(apple == clone);
        clone.getFruit().setType("cool");
//        clone.setFruit(fruit);
        System.out.println(apple);
        System.out.println(clone);
    }
}
