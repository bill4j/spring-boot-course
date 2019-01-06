package com.dynamic.springbootbvexcetionhandler.service;

import com.dynamic.springbootbvexcetionhandler.exception.AgeDeleteException;
import com.dynamic.springbootbvexcetionhandler.mapper.UserMapper;
import com.dynamic.springbootbvexcetionhandler.model.User;
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

    public int delete(Integer id) {
        // 业务认为不允许删除 18 岁一下的用户.
        if (selectByPrimaryKey(id).getAge() < 18) {
            throw new AgeDeleteException("不允许删除 18 岁以下的用户");
        }
        return userMapper.deleteByPrimaryKey(id);
    }

    public int add(User user) {
        return userMapper.insert(user);
    }
}

