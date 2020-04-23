package com.els.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author dx
 * @create 2020/4/23 17:06
 * @for new
 * executor 执行器
 * executorService  submit
 * future callable
 * newfixedthreadpool
 * 线程池并行进行数据计算
 */
public class Test1 {
    public static void main(String[] args) {
//        Executors.newFixedThreadPool()
//        Executors.newCachedThreadPool();
        try {
//            test2();
//            test3();
//            test4();
//            test5();
//            test6();
            test7();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test7() throws Exception {
        int sum=0;
        for (int i = 0; i <= 100; i++) {
            sum+=i;
        }
        System.out.println(sum);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask task = new ForkJoinTask(0,100);
        pool.execute(task);
        System.out.println(task.get());
    }

    static class ForkJoinTask extends RecursiveTask<Long> {
        long start, end;
        long threshold = 10;

        public ForkJoinTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= 10) {
                long sum = 0;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }
            long mid = start + (end - start) / 2;
            ForkJoinTask left = new ForkJoinTask(start, mid);
            ForkJoinTask right = new ForkJoinTask(mid + 1, end);
            left.fork();right.fork();
            return left.join() + right.join();
        }
    }

    private static void test6() throws Exception {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
        service.execute(new r(1000));
        service.execute(new r(1500));
        service.execute(new r(2000));
        service.execute(new r(4000));
        service.execute(new r(7000));
        service.execute(new r(2500));
        service.execute(new r(1900));
        service.execute(new r(3000));
        service.execute(new r(5000));
        service.execute(new r(300));
        service.execute(new r(8000));
        service.execute(new r(600));
        service.execute(new r(600));
        System.in.read();
    }

    static class r implements Runnable {
        long time;

        public r(long time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName() + " exec task .");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test5() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + " exec task");
        }, 2000, TimeUnit.MILLISECONDS);

        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + " exec task..");
        }, 1000, 3000, TimeUnit.MILLISECONDS);
    }

    private static void test4() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " exec task");
            });
        }
    }

    private static void test3() throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " exec task");
            });
        }
        Thread.sleep(80000);
        System.out.println(service);
    }

    //    @Test
    //executorservice & newFixedThreadPool
    public static void test2() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
//        Future<Integer> a = service.submit(() -> 5);
        for (int i = 0; i < 7; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " exec task");
            });
        }
        Thread.sleep(1000);
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        System.out.println("service = " + service);
    }


    @Test
    public void test1() {
        new ExecutorImp().execute(() -> System.err.print("test"));
    }

    class ExecutorImp implements Executor {
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }
}
