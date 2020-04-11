package com.dx.proxy.common;

/**
 * @author dx
 * @create 2020/4/12 0:32
 * @for target object
 */
public class TeacherDao implements IteacherDao {
    @Override
    public void tellKnowledge() {
        System.out.println("老师正在授课。。");
    }
}
