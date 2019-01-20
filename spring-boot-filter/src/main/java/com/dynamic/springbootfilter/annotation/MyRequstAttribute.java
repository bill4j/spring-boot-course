package com.dynamic.springbootfilter.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface MyRequstAttribute {
    String value();
}
