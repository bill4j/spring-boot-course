package com.dynamic.controller;


import com.dynamic.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * user management controller
 *
 * @author Administrator
 * @date 2018/12/30
 * commpany: yonyou
 * version:v1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/get")
    public User findById(@RequestParam long id) {
    logger.debug("id = {}",id);
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

    @GetMapping("/getByName/{name}")
    public User findByName(@PathVariable String name) {
        logger.info("name = {}",name);
        User resultuser = new User();
        if ("bill".equals(name)) {
            resultuser.setId(3453445L);
            resultuser.setAge(18);
            resultuser.setName(name);
            resultuser.setPhoneNumber("18232343840");
            logger.info(resultuser.toString());
            return resultuser;
        }
        return resultuser;
    }

}
