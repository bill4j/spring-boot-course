package com.dynamic.bill4j.springbootcallback.exception;
/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/15
 * company: yonyou
 * version:v1.0.0
 */
public class ExecuteTimeHandlerException extends RuntimeException {
    public ExecuteTimeHandlerException() {
        super();
    }

    public ExecuteTimeHandlerException(String message) {
        super(message);
    }

    public ExecuteTimeHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExecuteTimeHandlerException(Throwable cause) {
        super(cause);
    }

    public ExecuteTimeHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
