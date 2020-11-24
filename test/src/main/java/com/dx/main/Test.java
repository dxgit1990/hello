package com.dx.main;

import com.dx.pojo.User;
import com.dx.pojo.UserResult;
import com.google.gson.Gson;

import java.util.Date;

/**
 * @author dx
 * @create 2020/11/19 0:04
 * @for new
 */

public class Test {

    @org.junit.Test
    public void sysout(){

        User user = new User("lucy","5431");
        String json=new Gson().toJson(user);
        UserResult result=new UserResult();
        result.setCreateTime(new Date());
        result.setMsg(json);
        String s = new Gson().toJson(result);
        System.out.println(s);
        System.out.println("&&&&&&&&&&&&&&&");
        UserResult result1 = new Gson().fromJson(s, UserResult.class);
        System.out.println(result1);
        User user1 = new Gson().fromJson(result1.getMsg(), User.class);
        System.out.println(user1);
        
    }
}
