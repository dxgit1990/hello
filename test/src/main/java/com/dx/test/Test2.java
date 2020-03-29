package com.dx.test;

import com.dx.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengx
 * @date 2020/3/23-23:27
 * @for create new
 */
public class Test2 {
    public static void main(String[] args) {
        testClazz();
//        testMap();
        test();
    }


    private static void test() {
        List<User> list = new ArrayList<>();
        list.add(null);
        for (User user : list) {
            System.out.println("user = " + user);
            System.out.println("");
        }
    }

    private static void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("abc", "tom");
        String put = map.put("abc", "lucy");
        System.out.println(put);

    }


    private static void testClazz() {
        Test2 test2 = new Test2();
        System.out.println(test2.getClass());
    }
}
