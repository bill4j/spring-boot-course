package com.dynamic.springbootfilter.event.proxypattern.dynamicproxybaseonjdk;

import java.lang.reflect.Proxy;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/21
 * company: yonyou
 * version:v1.0.0
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(realSubject);
        Class cls = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), dynamicProxyHandler);
        subject.request();

    }
}
