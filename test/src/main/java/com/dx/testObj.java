package com.dx;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author dx
 * @create 2020/11/6 0:28
 * @for new
 */
public class testObj {

    public static void main(String[] args) {
        testObj tb = new testObj();
        String s = ClassLayout.parseInstance(tb).toPrintable();
        System.out.println("s = " + s);
    }
}
