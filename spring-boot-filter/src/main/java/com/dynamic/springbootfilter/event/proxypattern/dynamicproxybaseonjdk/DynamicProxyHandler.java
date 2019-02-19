package com.dynamic.springbootfilter.event.proxypattern.dynamicproxybaseonjdk;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/21
 * company: yonyou
 * version:v1.0.0
 */
public class DynamicProxyHandler implements InvocationHandler {

    private  RealSubject realSubject;


    public DynamicProxyHandler(RealSubject realSubject) {
        this.realSubject = realSubject;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.springbootfilter.event.proxypattern.staticproxy.DynamicProxyHandler{");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invokes = null;
        System.out.println("before calling  real subject method: " + method.getName() + " ");
        invokes = method.invoke(realSubject, args);
        System.out.println("after request real subject method: " + method.getName() + " ");
        return invokes;
    }
}
