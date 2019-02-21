package com.dynamic.bill4j.controller;

import com.dynamic.bill4j.model.User;
import com.dynamic.bill4j.service.UserService;
import com.dynamic.bill4j.util.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * test global exception handler
 *
 * @author Administrator
 * @date 2019/1/6
 * commpany: yonyou
 * version:v1.0.0
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/index")
    public String index() {

        return "user-list";
    }
@GetMapping("/add")
    public String add() {
        return "user-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultBean add(User user) {
        userService.add(user);
        return ResultBean.success();
    }

    @PostMapping("/addByJson")
    @ResponseBody
    public ResultBean addByJson(@RequestBody User user) {
        userService.add(user);
        return ResultBean.success();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResultBean delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return ResultBean.success();
    }

    @GetMapping("/list")
    @ResponseBody
    public ResultBean<User> list() {
        return ResultBean.success(userService.selectAll());
    }

}
