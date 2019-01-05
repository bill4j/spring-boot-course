package com.dynamic.springbootlogback;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * a sample log aspect demo ，demonstrate how spring-aop works with aspectj and jdk
 *
 * @author Administrator
 * @date 2018/12/31
 * commpany: yonyou
 * version:v1.0.0
 */
@Aspect
@Component
public class SampleControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleControllerAspect.class);

    /**
     * 给所有webcontroller层的方法加入自动的日志切面，打印入参和返回值
     */
    @Pointcut(value = "execution(public * com.dynamic.springbootlogback.controller.*.*(..))")
    public void weblog() {

    }
    //join_point

    // define advice

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) {
        //target
        LOGGER.debug("进入前置通知：dorBefore方法");
        //记录请求的内容：
        // 请求的IP，方式，url,
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        // 解析请求报文，使用MDC,打印日志，也可在前置通知中获取
        MDC.put("SESSION_ID", req.getSession().getId());
        MDC.put("IP", req.getRemoteAddr());
        MDC.put("URL", req.getRequestURL().toString());

        Object[] objects = joinPoint.getArgs();

        Signature signature = joinPoint.getSignature();
        LOGGER.debug("signature ={}", signature.toString());
        LOGGER.debug("方法：{}", signature.getName());
        LOGGER.debug("方法所在的类：{}", signature.getDeclaringType());
        LOGGER.debug("方法所在的包：{}", signature.getDeclaringTypeName());

        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        LOGGER.debug("方法参数的名字：{}", Arrays.toString(parameterNames));
        LOGGER.debug("方法的参数的值：{}", Arrays.toString(objects));


        LOGGER.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());


        //wave

    }

    @AfterThrowing(value = "weblog()", throwing = "e")
    public void doWhenThrowing(JoinPoint joinPoint, Throwable e) {
        LOGGER.error("方法执行时，发生了异常", e);
    }

    @AfterReturning(returning = "returnedValues", pointcut = "weblog()")
    public void doAfterReturning(Object returnedValues) {
        LOGGER.debug("方法的返回值为：{}", returnedValues);
    }

    @After("weblog()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.debug("whatever happened i very execute finally !");
        MDC.clear();

    }


    //
    // @Around("weblog()")
    // public Object doArround(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
    //     try {
    //         Object object = proceedingJoinPoint.proceed();
    //         return object;
    //     } catch (Throwable throwable) {
    //         // throw new Exception(throwable);
    //
    //     }
    //
    // }
    //use the aspect（or Config the aspect）


}
