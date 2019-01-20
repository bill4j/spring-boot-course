package com.dynamic.springbootfilter.event.oopbased;

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
public class Heater {
    private int temperature;
    private Set<Observer> observers;

    public void addObserver(Observer observer) {
        if (observers == null) {
            observers = new HashSet<>();
        }
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observers != null) {
            observers.remove(observer);
        }else{
            return ;
        }
    }

    public int countObservers() {
        if (observers != null) {
           return observers.size();
        }
        return 0;
    }

    public void boilWater() {
        for (int i = 0; i <= 100; i++) {
            this.temperature=i;
            if (temperature > 96) {
                this.notifyObservers(temperature);
            }
        }
    }

    public void notifyObservers(int temperature) {
        if (observers != null) {
            observers.forEach(observer -> observer.watchAndUpdate(temperature));
        }
    }
    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("event.oopbased.Heater{");
        sb.append("temperature=").append(temperature);
        sb.append('}');
        return sb.toString();
    }
}
