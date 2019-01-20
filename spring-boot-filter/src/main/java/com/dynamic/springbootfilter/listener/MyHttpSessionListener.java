package com.dynamic.springbootfilter.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * first HttpSessionListener to demonstrate how use it
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
@WebListener("myHttpSessionListener")
public class MyHttpSessionListener implements HttpSessionListener {
    private static Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        logger.info("session创建");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session销毁");

    }
}