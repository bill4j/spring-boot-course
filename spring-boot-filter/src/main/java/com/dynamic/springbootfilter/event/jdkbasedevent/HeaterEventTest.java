package com.dynamic.springbootfilter.event.jdkbasedevent;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class HeaterEventTest {
    public static void main(String[] args) {
        HeaterEventSource heater = new HeaterEventSource();
        heater.addListener(new AlarmListener());
        heater.addListener(new DIsplayListener());
        heater.boilWater();
    }


}
