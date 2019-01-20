package com.dynamic.springbootfilter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * first filter demo
 * Created by Administrator on 2019/1/9.
 * commpany: yonyou
 * version:v1.0.0
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter{

    private static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
LOGGER.info("my filter just init……");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = httpRequest.getRequestURI();
        LOGGER.info("请求的地址: {}", url);
            LOGGER.info("请求的session id: {}",httpRequest.getSession().getId().toString());
        LOGGER.info("before do_filter action , write your code here , before do_filter!");
//example:setMaxInactiveInterval,session will destroy after 1 min
        httpRequest.getSession().setMaxInactiveInterval(1*60);
        httpRequest.setAttribute("customArg","bill cindy alice ! they are family ! wonderful!");
        chain.doFilter(httpRequest, httpResponse);
        LOGGER.info("filter response action , write your code here, after do filter!");
        //example: addCookie and set a invalid status code to demonstrate
        // httpResponse.getOutputStream().flush();
    }

    @Override
    public void destroy() {
LOGGER.info("my filter was destroy!!");
    }
}

