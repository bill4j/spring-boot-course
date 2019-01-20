package com.dynamic.springbootfilter.event.observepattern;

import java.util.Collection;
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
public class HeaterSubject implements Subject {
    private int temperature;
    private Set<Observer> observers= new HashSet<>();

    @Override
    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers != null) {
            observers.remove(observer);
        }else{
            return ;
        }
    }

    @Override
    public void removeAll() {
        if (observers != null) {
            observers.removeAll(observers);
        } else {
            return;
        }

    }

    @Override
    public int countObservers() {
        if (observers != null) {
            return observers.size();
        }
        return 0;
    }

    @Override
    public void notifyAllObservers(Collection<Observer> observers,Object data) {
        if (observers != null) {
            observers.forEach(observer -> observer.watchAndUpdate(temperature));
        }
    }

    @Override
    public void notifyObserver(Observer observer,Object data) {
        if (observers != null) {
            observer.watchAndUpdate(data);
        }
    }

    public void boilWater() {
        for (int i = 0; i <= 100; i++) {
            this.temperature=i;
            if (temperature > 96) {
                this.notifyAllObservers(observers,temperature);
            }
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
