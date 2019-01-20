package com.dynamic.springbootfilter.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * my first listener to demonstrate how to use ServeletListener technology
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
@WebListener("MyListener")
public class MyServletListener implements ServletContextListener {
    private static Logger LOGGER = LoggerFactory.getLogger(MyServletListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("监听器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("监听器销毁");
    }
}

