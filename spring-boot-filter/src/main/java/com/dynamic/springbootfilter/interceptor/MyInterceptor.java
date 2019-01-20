package com.dynamic.springbootfilter.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * first interceptor illustrator
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyInterceptor.class);
    public MyInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
LOGGER.info("===>>>preHandle i got the first interceptor handler , yes i love spring-boot now ! just enjoy coding with spring - spring-mvc -and spring-boot !");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("<<<<===postHandle i got the first interceptor handler , yes i love spring-boot now ! just enjoy coding with spring - spring-mvc -and spring-boot !");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info(" afterCompletion =====》》》》 i got the first interceptor handler , yes i love spring-boot now ! just enjoy coding with spring - spring-mvc -and spring-boot !");
        super.afterCompletion(request, response, handler, ex);
    }


}
