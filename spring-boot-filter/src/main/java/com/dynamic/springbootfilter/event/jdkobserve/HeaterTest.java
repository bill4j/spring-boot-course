package com.dynamic.springbootfilter.event.jdkobserve;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class HeaterTest {
    public static void main(String[] args) {
        HeaterSubject heaterSubject = new HeaterSubject();
        heaterSubject.addObserver(new Alarm());
        heaterSubject.addObserver(new Display());
        System.out.println("how many observers in HeaterSubject ? the answer is : " + heaterSubject.countObservers() +" ");
        heaterSubject.boilWater();
    }
}
