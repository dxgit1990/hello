package com.dx.pojo;

import java.io.Serializable;

/**
 * @author dx
 * @create 2020/4/14 1:59
 * @for new
 */
public class Apple implements Cloneable, Serializable {
    private String color;
    private Fruit fruit;

    public Apple(String color, Fruit fruit) {
        this.color = color;
        this.fruit = fruit;
    }

    public Apple() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public Apple clone() {
        try {
            Apple apple = (Apple) super.clone();//浅复制
            apple.fruit = this.fruit.clone();
            return apple;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", fruit=" + fruit.type +
                '}';
    }

    public static class Fruit implements Cloneable {
        String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Fruit(String type) {
            this.type = type;
        }

        @Override
        protected Fruit clone() {
            try {
                return (Fruit) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public Fruit() {
        }
    }
}
