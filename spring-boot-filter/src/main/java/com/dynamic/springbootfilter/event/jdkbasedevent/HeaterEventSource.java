package com.dynamic.springbootfilter.event.jdkbasedevent;

import java.util.HashSet;
import java.util.Set;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class HeaterEventSource {
    public int getTemperature() {
        return temperature;
    }

    private int temperature ;
    private Set<HeaterLisener> eventListenerSet = new HashSet<>();

    public void addListener(HeaterLisener heaterLisener) {
        if (heaterLisener == null) {
            throw new NullPointerException();
        } else {
            eventListenerSet.add(heaterLisener);
        }
    }

    public void removeListener(HeaterLisener heaterLisener) {
        if (heaterLisener == null) {
            return;
        } else {
            eventListenerSet.remove(heaterLisener);
        }
    }

    private void notifyEventListeners(WaterBoilEvent event) {
        if (eventListenerSet != null) {
            //如果当前状态是
            eventListenerSet.forEach(eventListener -> eventListener.update(event));
        }
    }
    public void boilWater() {
        WaterBoilEvent event = new WaterBoilEvent(this);
        for (int i = 0; i <= 100; i++) {
            this.temperature=i;
            //todo 考虑如何：改为状态判断，并且让不同的listener执行不同的方法
            if (temperature > 98) {
                notifyEventListeners(event);
            }
        }
    }

}
