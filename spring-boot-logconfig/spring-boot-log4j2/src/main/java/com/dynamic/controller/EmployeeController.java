package com.dynamic.controller;

import com.dynamic.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * test
 *
 * @author Administrator
 * @date 2018/12/30
 * commpany: yonyou
 * version:v.1.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @RequestMapping
    public String index() {
        logger.debug("this is a log test, debug");
        logger.info("this is a log test, info");
        return "hello world";
    }

    @GetMapping("/get")
    public User findById(@RequestParam long id) {
        logger.debug("id = {}", id);
        User resultuser = new User();
        if (id == 6688) {
            resultuser.setAge(18);
            resultuser.setName("bill");
            resultuser.setPhoneNumber("18232343840");
            resultuser.setId(id);
            logger.debug(resultuser.toString());
            return resultuser;
        }
        return resultuser;
    }
}
