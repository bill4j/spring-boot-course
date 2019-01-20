package com.dynamic.bill4j.springbootcallback.exception;

import com.dynamic.bill4j.springbootcallback.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * a global execption handler use aop
 *
 * @author Administrator
 * @date 2019/1/6
 * commpany: yonyou
 * version:v1.0.0
 */
@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);
    @ExceptionHandler
    public ResultBean methodArgumentNotValid(BindException e) {
        LOGGER.error("参数校验失败",e);
        StringBuilder errorMessage = new StringBuilder();
        e.getAllErrors().forEach(objectError ->
                errorMessage.append(objectError.getDefaultMessage()).append(",")
        );
        return ResultBean.error(1, errorMessage.toString());
    }

    @ExceptionHandler
    public ResultBean methodArgumentNotValidForJsonArgumentResolver(MethodArgumentNotValidException e) {
        LOGGER.error("json参数绑定到对象失败",e);
        StringBuilder errorMessage = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach( errors-> errorMessage.append(errors.getDefaultMessage()).append(",") );
        return ResultBean.error(1, errorMessage.toString());
    }

    @ExceptionHandler
    public ResultBean unKnowException(Exception e) {
        LOGGER.error("未知异常", e);
        //发送邮件，或者短信通知
        return ResultBean.error(-999, "发生了未知异常，请联系系统管理员");
    }

    @ExceptionHandler
    public ResultBean ageDeleteException(AgeDeleteException e) {
        LOGGER.error("不能删除18岁以下的用户",e);
        return ResultBean.error(-1, "不能删除18岁以下的用户");
    }

    @ExceptionHandler
    public ResultBean executeTimeHandlerException(ExecuteTimeHandlerException e) {
        LOGGER.error("error !!！when we do a BasicProfiling of method executeTime ",e);
        return ResultBean.error(-1, "监控方法执行时间的切面类中的某个方法发生了异常！请刷新页面重试！");
    }
}
