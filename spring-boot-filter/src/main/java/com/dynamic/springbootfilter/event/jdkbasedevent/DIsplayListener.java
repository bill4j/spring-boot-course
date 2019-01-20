package com.dynamic.springbootfilter.event.jdkbasedevent;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class DIsplayListener implements HeaterLisener {
    public void showTemperature(WaterBoilEvent event) {
        System.out.println(" ");
        System.out.println("Display当前温度是:"+ event.getHeaterEventSource().getTemperature() +" ");
    }

    @Override
    public void update(WaterBoilEvent event) {
        showTemperature(event);
    }

}
