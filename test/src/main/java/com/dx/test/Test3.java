package com.dx.test;

/**
 * @author dx
 * @create 2020/4/9 12:44
 * @for new
 */
public class Test3 {
    public static void main(String[] args) {
//        test(1);
//        test2(1);
//        testHeapOverFlower();
        testFor();
    }

    private static void testFor() {

        for (int i = 0; i < 10; i++) {
//            A a=new Test3().new A(i);
            A a = new A(1);
        }
    }

    private static void testHeapOverFlower() {
//        for (; ; ) {
        byte[] bytes=null;
        while (true){
            bytes = new byte[1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024];
        }
    }

    public static void test(int start) {
        if (start <= 3) {
            test(start++);
            System.out.println(start);
        }
    }

    public static void test2(int start) {
        if (start <= 3) {
            test2(++start);
            System.out.println(start);
        }
    }

    public void testInnerClass(){
        A a = new A(1);
    }
    static class A {
        private int a;

        public A(int a) {
            this.a = a;
        }
        public int getA(){
            return this.a;
        }
        public void finalize() throws Throwable{
            System.out.println("对象被释放"+this.getA());
        }
    };
}
