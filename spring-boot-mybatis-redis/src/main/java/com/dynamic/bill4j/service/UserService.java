package com.dynamic.bill4j.service;

import com.dynamic.bill4j.mapper.UserMapper;
import com.dynamic.bill4j.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * user service
 * Created by Administrator on 2019/1/6.
 * commpany: yonyou
 * version:v1.0.0
 */
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


    public int delete( Integer id) {

        return userMapper.deleteByPrimaryKey(id);
    }


    public int add(User user) {
        return userMapper.insert(user);
    }
}

