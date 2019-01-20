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
public class Display implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        showTemperature(arg);
    }
    public void showTemperature(Object data) {
        System.out.println(" ");
        System.out.printf("Display当前温度是:%d°, ",data);
    }
}
