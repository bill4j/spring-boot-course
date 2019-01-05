package com.dynamic.entity;

/**
 * test spring-boot-demo
 *
 * @author Administrator
 * @date 2018/12/30
 * commpany: yonyou
 * version:v1.0.0
 */

public class User {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long id;
    public String name;
    public String phoneNumber;
    public int age;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.springbootlogback.entity.User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
