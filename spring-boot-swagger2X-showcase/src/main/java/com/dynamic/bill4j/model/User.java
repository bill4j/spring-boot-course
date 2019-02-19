package com.dynamic.bill4j.model;

/**
 * user entity
 *
 * @author Administrator
 * @date 2019/1/6
 * commpany: yonyou
 * version:v1.0.0
 */
public class User {
    /**
     * @NotNull://CharSequence, Collection, Map 和 Array 对象不能是 null, 但可以是空集（size = 0）。  
     * @NotEmpty://CharSequence, Collection, Map 和 Array 对象不能是 null 并且相关对象的 size 大于 0。  
     * @NotBlank://String 不是 null 且去除两端空白字符后的长度（trimmed length）大于 0。 
     */

    public Integer id;
    public String username;
    public Integer age;
    public String email;
    public String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail( String email) {

        this.email = email;
    }

    public String getPhoneNumber() {
        return  phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.springbootbvexcetionhandler.model.User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
