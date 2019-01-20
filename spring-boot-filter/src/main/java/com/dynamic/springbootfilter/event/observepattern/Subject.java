package com.dynamic.springbootfilter.event.observepattern;

import java.util.Collection;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public interface Subject {

       void addObserver(Observer observer);

      void removeObserver(Observer observer);

      void removeAll();

      int countObservers();

    void notifyAllObservers(Collection<Observer> observers, Object data);

    void notifyObserver(Observer observer, Object data);

}
