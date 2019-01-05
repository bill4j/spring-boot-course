package com.dynamic.springbootfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * user controller
 *
 * @author Administrator
 * @date 2019/1/5
 * commpany: yonyou
 * version:v1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("title", "spring-boot-freemarker");
        modelMap.put("name", "bill");
        return "index";

    }

}
