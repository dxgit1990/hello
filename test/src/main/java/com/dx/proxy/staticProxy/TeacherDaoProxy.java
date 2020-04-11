package com.dx.proxy.staticProxy;

import com.dx.proxy.common.IteacherDao;
import com.dx.proxy.common.TeacherDao;

/**
 * @author dx
 * @create 2020/4/12 0:33
 * @for static proxy object
 */
public class TeacherDaoProxy implements IteacherDao {

    private TeacherDao teacherDao;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void tellKnowledge() {
        long start = System.currentTimeMillis();
        teacherDao.tellKnowledge();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("授课完成，时长： " + (end - start) / 1000.0+" s.");
    }
}
