package com.example.demo;

/**
 * Created by Administrator on 2018/12/28.
 * commpany:
 * version:
 */
public class User {
    public long id ;
    public String name;
    public String sex;
    public int age;
    public String phoneNumber;

    @Override
    public String toString() {
        StringBuilder userInfo = new StringBuilder().append("[ User detail info :")
                .append("name,"+this.name)
                .append("sex,"+this.sex)
                .append("age"+this.age)
                .append("phoneNumber"+this.phoneNumber);
        return userInfo.toString();
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String securedPhoneNumber = phoneNumber.replace(phoneNumber.substring(3,7),"****");
        this.phoneNumber = securedPhoneNumber;
    }
}
