package com.dynamic.springbootfilter.event.jdkobserve;

import java.util.Observable;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class HeaterSubject extends Observable {
    private int temperature ;

    public void boilWater() {
        for (int i = 0; i <= 100; i++) {
            this.temperature=i;
            if (temperature > 96) {
                super.setChanged();
                super.notifyObservers(temperature);
            }
        }
    }
}
