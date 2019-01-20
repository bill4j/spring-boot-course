package com.dynamic.bill4j.springbootcallback.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * user entity
 *
 * @author Administrator
 * @date 2019/1/6
 * commpany: yonyou
 * version:v1.0.0
 */
@Data
public class User {
    /**
     * @NotNull://CharSequence, Collection, Map 和 Array 对象不能是 null, 但可以是空集（size = 0）。  
     * @NotEmpty://CharSequence, Collection, Map 和 Array 对象不能是 null 并且相关对象的 size 大于 0。  
     * @NotBlank://String 不是 null 且去除两端空白字符后的长度（trimmed length）大于 0。 
     */

    public Integer id;
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6,max = 20,message = "用户名需要为 6 - 20 个字符")
    public String username;
    @NotNull(message = "年龄不能为空")
    public Integer age;
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    public String email;
    @NotBlank(message = "手机号码不能为空")
    public String phoneNumber;


}
