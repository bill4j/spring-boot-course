package com.dynamic.bill4j.springbootcallback.controller;

import com.dynamic.bill4j.springbootcallback.annotation.ShowExecuteTime;
import com.dynamic.bill4j.springbootcallback.model.User;
import com.dynamic.bill4j.springbootcallback.util.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class UserController {


    @PostMapping("/add")
    @ResponseBody

    public ResultBean add(@Valid User user) {
        return ResultBean.success();
    }

    @PostMapping("/addByJson")
    @ResponseBody
    @ShowExecuteTime
    public ResultBean addByJson(@RequestBody @Valid User user) {
        log.info(user.toString());
        testMethod();
        return ResultBean.success();
    }
    /**
     *内部方法调用，无法直接使用aop拦截（所以，在这个方法上进行注解，无法被aspect拦截）
     */
    public void testMethod() {
        for (int i = 0; i < 5000; i++) {
            log.info("execute times : {}",i);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResultBean delete(@PathVariable("id") Integer id) {
        return ResultBean.success();
    }


}
