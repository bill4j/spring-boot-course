package com.dynamic.springbootfilter.config;

import com.dynamic.springbootfilter.customresovler.CustomArgumentResolver;
import com.dynamic.springbootfilter.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * illustrate for interceptor
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private static final String[] excludePathPatterns  = {"/xxx"};

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns(excludePathPatterns);
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CustomArgumentResolver());
    }
}
