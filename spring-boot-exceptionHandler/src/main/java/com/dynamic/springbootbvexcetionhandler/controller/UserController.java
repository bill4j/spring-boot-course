package com.dynamic.springbootbvexcetionhandler.controller;

import com.dynamic.springbootbvexcetionhandler.model.User;
import com.dynamic.springbootbvexcetionhandler.service.UserService;
import com.dynamic.springbootbvexcetionhandler.util.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public ResultBean add( @Valid User user) {
        userService.add(user);
        return ResultBean.success();
    }

    @PostMapping("/addByJson")
    @ResponseBody
    public ResultBean addByJson(@RequestBody @Valid User user) {
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
