package com.stone.mvp.bean;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 18 52
 */
public class UserBean {

    private String name;
    private int age;

    public UserBean() {
    }

    public UserBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
