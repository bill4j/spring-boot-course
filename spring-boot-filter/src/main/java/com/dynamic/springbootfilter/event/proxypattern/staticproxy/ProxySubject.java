package com.dynamic.springbootfilter.event.proxypattern.staticproxy;
/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/21
 * company: yonyou
 * version:v1.0.0
 */
public class ProxySubject implements Subject {
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public RealSubject getRealSubject() {
        return realSubject;
    }


    @Override
    public void request() {
        System.out.println("before request real subject ");
        realSubject.request();
        System.out.println("after request real subject ");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.springbootfilter.event.proxypattern.staticproxy.DynamicProxyHandler{");
        sb.append("realSubject=").append(realSubject);
        sb.append('}');
        return sb.toString();
    }
}
