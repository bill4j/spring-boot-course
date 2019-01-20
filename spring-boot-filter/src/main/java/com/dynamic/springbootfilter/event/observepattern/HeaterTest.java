package com.dynamic.springbootfilter.event.observepattern;

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
        HeaterSubject heater = new HeaterSubject();
        heater.addObserver(observerAlarm);
        heater.addObserver(observerDisplay);
        System.out.println("==== var ObservesCount'value is " + heater.countObservers() + " ====");
        heater.removeObserver(observerDisplay);
        heater.boilWater();
        System.out.println(" ");
        System.out.println("==== var ObservesCount'value is " + heater.countObservers() + " ====");

    }
}
