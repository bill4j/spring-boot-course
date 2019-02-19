package com.dynamic.springbootfilter.event.proxypattern.staticproxy;

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
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.request();
    }
}
