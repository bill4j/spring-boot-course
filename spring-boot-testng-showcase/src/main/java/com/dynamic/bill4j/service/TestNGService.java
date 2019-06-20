package com.dynamic.bill4j.service;

import com.dynamic.bill4j.exception.MyCustomeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author bill-smith liuwb
 * @version v1.0
 * @Package com.dynamic.bill4j.service
 * @data 2019/3/26 9:50
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @email 18232480449@163.com
 * @contract https://github.com/BillCindy
 * @blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@Component
@Slf4j
public class TestNGService {

    public void add(int a, int b) {

        int result = 0;
        log.debug("params a = {},b={}", a, b);
        result = a + b;
        log.debug("result is {}", result);
        int errorTest = 0;
        try {
            errorTest = a / b;
            log.debug("errorTest {}",errorTest);
        } catch (Exception e) {
            //错误的写法示例：不要记录异常e的信息，在日志里面。交给框架和容器来处理。
//            log.error("除数不能为零",e);
            //正确的写法：如果，确实需要记录一下，并且重新抛出异常的话。不要将e写入到日志中。
//            log.error("除数不能为零");
            log.error("除数不能为零");
            throw new MyCustomeException("除数不能为零 {}",e.getCause());

        }

    }

}
