package com.dynamic.bill4j.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bill-smith liuwb
 * @version v1.0
 * @Package com.dynamic.bill4j.controller
 * @data 2019/3/25 21:43
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @email 18232480449@163.com
 * @contract https://github.com/BillCindy
 * @blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@RestController
@Slf4j
public class HelloTestNG {
    @GetMapping("/helloTestNG")
    public String sayHelloToTestNG() {
      log.info("hello TestNG !");
        return "hello TestNG !";
    }
}
