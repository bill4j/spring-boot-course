package com.dynamic.springbootfilter.event.oopbased;

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
        Observer observerAlarm = new Alarm();
        Observer observerDisplay = new Display();
        Heater heater = new Heater();
        heater.addObserver(observerAlarm);
        heater.addObserver(observerDisplay);
        System.out.println("==== var ObservesCount'value is " + heater.countObservers() + " ====");
        heater.boilWater();

    }
}
