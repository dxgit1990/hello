package com.dx.pojo;

/**
 * @author dx
 * @create 2020/4/11 18:55
 * @for new
 */
public abstract class Result {
    private Integer code;
    private String status;

    public Result(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
