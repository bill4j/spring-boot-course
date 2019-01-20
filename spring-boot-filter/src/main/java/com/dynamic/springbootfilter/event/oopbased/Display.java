package com.dynamic.springbootfilter.event.oopbased;
/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class Display implements Observer {

    public void showTemperature(int temperature) {
        System.out.println(" ");
        System.out.printf("Display当前温度是:%d°, ",temperature);
    }

    @Override
    public void watchAndUpdate(int param) {
        this.showTemperature(param);
    }
}
