package com.dx.interview;

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




    public static void main(String[] args) {
        try {
            System.out.println(Test.generateNum( 1, 2, 3,7));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Test.getFrequentChart("abbbedfs"));
        System.out.println(Integer.MAX_VALUE+1);
    }

}
