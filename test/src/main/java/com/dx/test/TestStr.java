package com.dx.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author dx
 * @create 2020/7/1 9:41
 * @for new
 */
public class TestStr {
    public static final String STR="abc";
    public static void main(String[] args) {
//        testStr("abc");
//        testNum();
        testArrays();

//        testFOr();
    }

    private static void testFOr() {
        int[] data={1,2,3,4};
        Arrays.asList(data).stream().forEach(a->System.out.println(a));
    }

    private static void testArrays() {
        int[] data={1,2,3,4};
        String[] strings={"tom","jack","lucy"};
        List<int[]> ints = Arrays.asList(data);
        List<String> strings1 = Arrays.asList(strings);
        System.out.println("ints = " + ints);
        System.out.println("ints.size() = " + ints.size());
        System.out.println("strings = " + strings1);
        System.out.println(strings1.size());
    }


    private static void testNum() {
        int num=1;
        for (int i = 0; i < 30; i++) {
            num=2*num;
            if(i==17){
                System.out.println("num = " + num);
            }
            if(num >=300000){
                System.out.println("i = " + ++i);
                break;
            }
        }
        System.out.println("num = " + num);
    }

    private static void testStr(String s3) {
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);
        System.out.println(s1==STR);
        System.out.println(s3==s1);
    }
}
