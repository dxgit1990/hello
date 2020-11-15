package com.dx.interview;

import java.io.UnsupportedEncodingException;

/**
 * @author dx
 * @create 2020/4/23 14:09
 * @for interview test
 */
public class Test {

    //有大于等于六的数，返回  没有抛异常
    public static Integer generateNum(Integer... nums) throws Exception {
        if (nums == null) throw new RuntimeException("参数为空");
        boolean flag = true;
        for (Integer num : nums) {
            if (num >= 6) {
                return num;
            }
        }
        if (flag) {
            throw new RuntimeException("nums 没有大于等于6的数");
        }
        return null;
    }

    //传入一个不为空的字符串，输出出现最多的字符
    public static char getFrequentChart(String str) {
        char[] chars = str.toCharArray();
        int[]temp=new int[500];
        for (int i = 0; i < chars.length; i++) {
            temp[(int)(chars[i])]++;
        }
        int index=0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]>temp[index]){
                index=i;
            }
        }

        return (char)index;
    }


    public static void changeCharacter(){
        String str = "1.redis是纯内存操作 ，速度比磁盘操作快很多";
        try {
            byte[] bytes = str.getBytes("iso8859-1");
            System.out.println("iso...>>>>    "+new String(bytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

        public static void testSwitch(){
            byte bt= "hello".getBytes()[0];
            switch (bt){

            }
        }

        public static void testBreak(){

            try {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 11; k++) {

                            throw new RuntimeException("skip out");
                        }
                        System.out.println("第二层循环 = " + j);
                    }
                    System.out.println("第一层循环 = ");
                }
            } catch (RuntimeException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
            System.out.println("over");

        }

        public static void testCase(){
            position:
            for (int i = 0; i < 5; i++) {
                if(i%3==1){
                    System.out.println(i);
                break position;}
                System.out.println("i = " + i);
            }

        }

        public static void main(String[] args) {
//        try {
//            System.out.println(Test.generateNum( 1, 2, 3,7));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Test.getFrequentChart("abbbedfs"));
//        System.out.println(Integer.MAX_VALUE+1);
//        changeCharacter();
//        testBreak();
            testCase();

            System.out.println(1%3);
    }


}
