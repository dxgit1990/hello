package com.dx.test;

import java.util.Random;

/**
 * @author dx
 * @create 2020/4/9 11:17
 * @for test inner class
 */
public class Person {
    private int id;
    private String name;
    private Cat cat = new Cat();

    public int getNum() {
        return new Random().nextInt(5);
    }

    class Cat {
        private int color;

        public Cat() {
            this.color = getNum();
        }

        public void say() {
            System.out.println("color = " + color);
        }
    }

    static class Fash {
        private int weight;

        public Fash() {
            this.weight = new Random().nextInt(5);
        }

        public void say() {
            synchronized (this){}
            System.out.println("weight = " + weight);
        }

        public static void hell0() {
            synchronized (Fash.class) {
            }
            System.out.println("hello method");
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        Cat cat = person.new Cat();
        cat.say();
        System.out.println(person.cat.color);
        Fash fash = new Fash();
        fash.say();
        new Person.Fash().say();
        Person.Fash.hell0();
        Cat cat1 = new Person().new Cat();
        System.out.println("cat1 = " + cat1.color);
    }
}
