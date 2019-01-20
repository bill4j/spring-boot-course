package com.dynamic.bill4j.springbootcallback.aop;

import com.dynamic.bill4j.springbootcallback.exception.ExecuteTimeHandlerException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/15
 * company: yonyou
 * version:v1.0.0
 */
@Aspect
@Component
@Slf4j
public class MethodExecuteTimeAndArgsHandler {

private static final int EXECUTE_OVERTIME = 50;
    @Pointcut("@annotation(com.dynamic.bill4j.springbootcallback.annotation.ShowExecuteTime)")
    public void executeTime() {
    }

    @Around("executeTime()")
    public Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint)  {

        Object[] objects = proceedingJoinPoint.getArgs();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        LocalDateTime startTime = LocalDateTime.now();
        log.debug("method {} with arguments {} , started at : {}",methodName,objects.toString(), startTime.toString());
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
            log.debug("after method " + methodName + "  with returning " + (result == null ? "NULL" : result.toString()));
        } catch (Throwable e) {
            throw new ExecuteTimeHandlerException(e);
        }
        LocalDateTime endTime = LocalDateTime.now();
        log.debug("method stopped  at : {}", endTime.toString());
        printExecuteTime(methodName,startTime, endTime);
        return result;
    }

    private void printExecuteTime(String methodName, LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        if (duration.toMillis() > EXECUTE_OVERTIME) {
            log.warn("warning : method {} executed in {}{}", methodName,duration.toMillis()," millis");
        }
    }
}
