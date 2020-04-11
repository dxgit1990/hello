package com.dx.test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author dx
 * @create 2020/4/9 11:00
 * @for new
 */
public class ReadProperties {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("locale = " + locale);
        ResourceBundle bundle = ResourceBundle.getBundle("D://read.txt");
        System.out.println(bundle.getKeys());
        System.out.println(bundle.getString("name"));
    }
}
