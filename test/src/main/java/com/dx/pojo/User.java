package com.dx.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author dengx
 * @date 2020/3/20-16:57
 * @for create new
 */
public class User implements Serializable {

    private static final long serialVersionUID = 3136953434751387180L;
    private String name;
    private String idCard;
    private Double salary;

    public User() {
    }


    public User(String name, String idCard, Double salary) {
        this.name = name;
        this.idCard = idCard;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getIdCard(), user.getIdCard()) &&
                Objects.equals(getSalary(), user.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIdCard(), getSalary());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", salary=" + salary +
                '}';
    }

}
