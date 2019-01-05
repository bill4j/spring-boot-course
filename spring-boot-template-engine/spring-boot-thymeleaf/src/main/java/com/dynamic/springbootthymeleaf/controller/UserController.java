package com.dynamic.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * user controller
 *
 * @author Administrator
 * @date 2019/1/5
 * commpany: yonyou
 * version: v1.0.0
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("title", "spring-boot-thymeleaf");
        return "index";
    }


}



