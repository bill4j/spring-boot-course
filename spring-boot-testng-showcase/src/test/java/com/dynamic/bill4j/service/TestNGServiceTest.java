package com.dynamic.bill4j.service;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author bill-smith liuwb
 * @version v1.0
 * @Package com.dynamic.bill4j.service
 * @data 2019/3/26 15:54
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @email 18232480449@163.com
 * @contract https://github.com/BillCindy
 * @blog https://blog.csdn.net/t131452n?viewmode=contents
 */
@Slf4j
public class TestNGServiceTest {

    TestNGService testNGService = new TestNGService();
    @BeforeMethod
    public void setUp() {
      log.info("set up 阶段");
    }

    @AfterMethod
    public void tearDown() {
        log.info("tearDown 阶段");
    }

    @Test
    public void testAdd() {
        testNGService.add(10,20);
        testNGService.add(0,20);
        testNGService.add(10,0);
    }
}