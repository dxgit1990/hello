package com.dx.test;

import com.dx.pojo.User;
import org.junit.Test;

/**
 * @author dx
 * @create 2020/4/12 17:54
 * @for new
 */
public class Test6 {
    @Test
    public void test() {
        User user = new User();
        System.out.println(new ServiceTest<User>(user).getClazz());

    }
}
