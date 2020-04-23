package com.els.thread.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author dx
 * @create 2020/4/23 17:05
 * @for linkedblockingqueue arrayblockingqueue delayqueue tranferqueue synronusqueue
 */
public class Test1 {
    private List<Integer> list = new ArrayList<>();

    @Before
    public void init() {
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(++i));
        }
    }


    @Test
    /**
     * 测试SynchronousQueue
     * add方法会报错，因为 SynchronousQueue队列的容量是0
     * 使用put方法添加数据 底层使用的transfer，会阻塞等待消费者立马消费
     */
    public void test6() throws Exception{
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        queue.add(5);
        queue.put(5);
    }

    /**
     * Test linkedtransferqueue
     * 消费者不能和生产者一个线程，需要单独起一个线程阻塞等待队列获取数值
     * 消费者要先启动，否则transfer()添加值会导致线程阻塞 程序不在执行
     *
     */
    @Test
    public void test5() throws Exception {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
//        queue.offer(5);
//        queue.add(5);
//        queue.put(5);
        queue.transfer(5);
        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    /**
     * 测试DelayQueue
     * 泛型类型必须是实现delayed接口的派生类
     * 只有使用take方法取值，获取的数据才是排序后的
     */
    public void test4() throws Exception {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        long now = System.currentTimeMillis();
        queue.offer(new DelayTask(now + 1000));
        queue.offer(new DelayTask(now + 2000));
        queue.offer(new DelayTask(now + 3000));
        queue.offer(new DelayTask(now + 500));
        queue.offer(new DelayTask(now + 1800));
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take().time);
        }
    }

    @Test
    public void test3() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.offer(i));
        }
    }

    @Test//test LinkedBlockingQueue
    public void test2() throws Exception {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        System.out.println(((LinkedBlockingQueue<Integer>) queue).offer(0, 3, TimeUnit.SECONDS));
        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue.peek());
        for (int i = 0; i < 9; i++) {
//            System.out.println(queue.offer(i));
            queue.put(i);
        }
        System.out.println(queue.size());
    }

    @Test//测试ConcurrentLinkedQueue
    public void test1() throws Exception {
        list.forEach(System.err::println);
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Thread.currentThread().sleep(500);
        queue.offer(15);
        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue.poll());
        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue.peek());
        System.out.println("queue.size() = " + queue.size());
//        System.out.println(queue.remove(0));
//        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue.offer(15));
        queue.forEach(System.err::println);
    }

    class DelayTask implements Delayed {
        long time;

        public DelayTask(long time) {
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o instanceof DelayTask) {
                DelayTask other = (DelayTask) o;
                if (time > other.time) {
                    return 1;
                } else if (time < other.time) {
                    return -1;
                } else {
                    return 0;
                }
            }
            return 0;
        }
    }
}
