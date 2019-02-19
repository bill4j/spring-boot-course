package com.dynamic.springbootfilter.event.proxypattern.staticproxy;
/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/21
 * company: yonyou
 * version:v1.0.0
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("from real_subject ...");
    }
}
