package com.dynamic.springbootfilter.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * test ServletRequestListener for demonstrate
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
@WebListener("MyServletRequestListener")
public class MyServletRequestListener implements ServletRequestListener {
    private static final String REQUEST_ATTRIBUTES_ATTRIBUTE = RequestContextListener.class.getName() + ".REQUEST_ATTRIBUTES";
private static final Logger LOGGER = LoggerFactory.getLogger(MyServletRequestListener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
LOGGER.info("ServletRequestListener destroyed !!!!");

    }

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
LOGGER.info("ServletRequestListener init !!!");
        if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
            throw new IllegalArgumentException("Request is not an HttpServletRequest: " + requestEvent.getServletRequest());
        } else {
            HttpServletRequest request = (HttpServletRequest)requestEvent.getServletRequest();
            ServletRequestAttributes attributes = new ServletRequestAttributes(request);
            request.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
            LocaleContextHolder.setLocale(request.getLocale());
            RequestContextHolder.setRequestAttributes(attributes);
        }
    }
}
