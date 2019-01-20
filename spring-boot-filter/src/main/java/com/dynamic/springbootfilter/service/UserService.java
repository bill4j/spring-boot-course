package com.dynamic.springbootfilter.service;

import com.dynamic.springbootfilter.exception.AgeDeleteException;
import com.dynamic.springbootfilter.mapper.UserMapper;
import com.dynamic.springbootfilter.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * user service
 * Created by Administrator on 2019/1/6.
 * commpany: yonyou
 * version:v1.0.0
 */
@Validated
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }


    @Min(value = 1,message = "必须删除成功")
    public int delete(@NotNull Integer id) {

        // Assert.isTrue(selectByPrimaryKey(id).getAge() > 18,"不允许删除18岁以下的用户");
        //业务认为不允许删除 18 岁一下的用户.
        if (selectByPrimaryKey(id).getAge() < 18) {
                     throw new AgeDeleteException();
                 }
        return userMapper.deleteByPrimaryKey(id);
    }


    public int add(User user) {
        return userMapper.insert(user);
    }
}

