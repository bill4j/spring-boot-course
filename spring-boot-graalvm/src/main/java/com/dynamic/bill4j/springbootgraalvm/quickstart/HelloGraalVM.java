package com.dynamic.bill4j.springbootgraalvm.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bill-smith liuwb
 * @version v1.0
 * @Package com.dynamic.bill4j.springbootgraalvm.quickstart
 * @data 2019/3/21 14:21
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @email 18232480449@163.com
 * @contract https://github.com/BillCindy
 * @blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@Slf4j
@RestController
@RequestMapping("/helloGraalVM")
public class HelloGraalVM {

    @GetMapping("/hello")
    public String sayHello() {
      log.info("hello GraalVm , i'm bill !");
        return "hello GraalVm , i'm bill !";
    }
}
