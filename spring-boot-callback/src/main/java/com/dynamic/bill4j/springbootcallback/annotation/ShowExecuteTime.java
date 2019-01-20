package com.dynamic.bill4j.springbootcallback.annotation;

import java.lang.annotation.*;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/15
 * company: yonyou
 * version:v1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface ShowExecuteTime {
}
