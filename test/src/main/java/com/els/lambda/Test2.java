package com.els.lambda;

import com.els.pojo.User;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {
    static List<User> list = new ArrayList<User>();

    static {
        list.add(new User("zhangsna", "zhangsa", "5000"));
        list.add(new User("lisi", "lisi", "2000"));
        list.add(new User("wagnwu", "wagnwu", "7500"));
        list.add(new User("wagnwu", "wagnwu", "7500"));
    }

    public static void main(String[] args) {
//		Supplier<T>
//		Function<T, R>
//		Predicate<T>
//		Consumer<T>
//		list.stream().forEach(System.err::println);
        long count = list.stream().count();
        System.err.println(count);
//		BinaryOperator<T>
//		Map<String, User> collect = list.stream()
//				.collect(Collectors.toMap(User::getName, Function.identity(), (oldValue, newValue) -> newValue));
//				.collect(Collectors.toMap(User::getName, Function.identity(), (oldValue, newValue) -> newValue));
//		Map<String, String> collect = list.stream()
//				.collect(Collectors.toMap(User::getName, User::getName, (old, newValue) -> newValue));
//		System.err.println(collect);
//		String collect = list.stream().map(User::getName).sorted().collect(Collectors.joining());
//		System.err.println(collect);
//		String reduce = list.stream().map(User::getName).sorted().reduce("", String::concat);
//		System.err.println(reduce);
        // 求和
        Double double1 = list.stream().map(u -> Double.valueOf(u.getSalary())).reduce(Double::sum).get();
        System.err.println(double1);
    }

    @Test
    public void test3(){
        List<User> list = new ArrayList<>();
        for (;;){
            list.add(new User());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test2() {
        list.stream().findFirst().ifPresent(System.err::println);
        IntStream.range(1, 5).forEach(System.err::print);
//        System.out.println(IntStream.range(1, 5).sum());
        HashMap<String, Set<User>> collect = list.stream().collect(Collectors.groupingBy(User::getSalary, HashMap::new, Collectors.toSet()));
        System.out.println(new Gson().toJson(collect));
    }

    @Test
    public void test1() {
//		filter(list, u -> Integer.valueOf(u.getSalary()) > 3000).forEach(u -> System.err.println(u.getSalary()));
        list.stream().filter(u -> Integer.valueOf(u.getSalary()) > 3000)
                .filter(u -> Integer.valueOf(u.getSalary()) > 5000).forEach(u -> System.err.println(u.getSalary()));
    }

    public List<User> filter(List<User> users, Predicate<User> pre) {
//		users.stream().filter(u->pre.test(u))
        List<User> temp = new ArrayList<>();
        for (User user : users) {
            if (pre.test(user)) {
                temp.add(user);
            }
        }
        return temp;
    }
}
