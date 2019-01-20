package com.dynamic.springbootfilter.aop;

import com.dynamic.springbootfilter.model.User;
import com.dynamic.springbootfilter.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * MyResponseBodyAdvice  illustate
 * Created by Administrator on 2019/1/10.
 * commpany: yonyou
 * version:v1.0.0
 */
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter methodParameter,
                                  MediaType mediaType, Class clas, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        ResultBean<User> resultbean= (ResultBean<User>) returnValue;
        //统一修改返回值/响应体
        LOGGER.info(resultbean.toString());
        resultbean.setMessage("rewrite before ResponseBodyWrite! i did it!");
        //返回修改后的值
        LOGGER.info("after modify == {}",resultbean.toString());
        return resultbean;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class clas) {
        //获取当前处理请求的controller的方法
        String methodName=methodParameter.getMethod().getName();
        LOGGER.info("methodName is ={}",methodName);
        // 不拦截/不需要处理返回值 的方法
        String method= "addByJson";
        //不拦截
        return !method.equals(methodName);
    }
}

