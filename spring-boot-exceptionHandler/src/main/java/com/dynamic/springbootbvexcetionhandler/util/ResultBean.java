package com.dynamic.springbootbvexcetionhandler.util;

import java.util.Collection;

/**
 * Created by Administrator on 2019/1/6.
 * commpany:
 * version:
 */
public  class ResultBean<T> {

    private int code;
    private String message;
    private Collection<T> data;

    private ResultBean() {

    }
    private ResultBean(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private ResultBean(int code, String message, Collection<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public static   ResultBean error(int code, String message) {
        ResultBean resultBean = new ResultBean(code, message);
        return resultBean;
    }

    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static <V> ResultBean<V> success(Collection<V> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setMessage("success");
        resultBean.setData(data);
        resultBean.setCode(0);
        return resultBean;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.springbootbvexcetionhandler.util.ResultBean{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
