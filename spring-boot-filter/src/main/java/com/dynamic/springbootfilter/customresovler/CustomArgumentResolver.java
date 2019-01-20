package com.dynamic.springbootfilter.customresovler;

import com.dynamic.springbootfilter.annotation.MyRequstAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.validation.constraints.NotNull;

/**
 * customResolver for demonstrate or illustrate
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
public class CustomArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomArgumentResolver.class);
    @Override
    public boolean supportsParameter( @NotNull MethodParameter methodParameter) {
        LOGGER.debug("ParameterAnnotation value is {}",methodParameter.getParameterAnnotation(MyRequstAttribute.class).toString());
       return methodParameter.getParameterAnnotation(MyRequstAttribute.class)!=null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        MyRequstAttribute attribute = methodParameter.getParameterAnnotation(MyRequstAttribute.class);

        LOGGER.debug("attribute is {}",attribute.value());
        nativeWebRequest.setAttribute("customArg2",nativeWebRequest.getParameter("customArg2"),WebRequest.SCOPE_SESSION);
        LOGGER.debug("native parameter customArg2 value is {}",nativeWebRequest.getParameter("customArg2"));
        // return nativeWebRequest.getAttribute(attribute.value(),WebRequest.SCOPE_REQUEST);
        return  nativeWebRequest.getAttribute(attribute.value(),WebRequest.SCOPE_SESSION);
    }
}
