package com.dynamic.springbootfilter.event.observepattern;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class Display implements Observer {

    public void showTemperature(Object data) {
        System.out.println(" ");
        System.out.printf("Display当前温度是:%d°, ",data);
    }

    @Override
    public void watchAndUpdate(Object data) {
        this.showTemperature(data);
    }
}
