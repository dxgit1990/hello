package com.dx.interview;

import java.util.Date;

/**
 * @author dx
 * @create 2020/11/19 0:02
 * @for new
 */
public class UserResult {

    private Date createTime;
    private String msg;

    public UserResult() {
    }

    public UserResult(Date createTime, String msg) {
        this.createTime = createTime;
        this.msg = msg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
