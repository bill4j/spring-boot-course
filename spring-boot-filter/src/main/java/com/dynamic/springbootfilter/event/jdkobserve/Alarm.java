package com.dynamic.springbootfilter.event.jdkobserve;

import java.util.Observable;
import java.util.Observer;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class Alarm implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        alertWarn(arg);
    }

    public void alertWarn(Object temperature) {
        System.out.println(" ");
        System.out.printf(" === Alarm warn!!!! 水已经烧开了！当前温度%d",temperature);
    }
}
