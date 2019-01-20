package com.dynamic.springbootfilter.event.jdkbasedevent;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class AlarmListener implements HeaterLisener {



    public void alertWarn(WaterBoilEvent event) {
        System.out.println(" ");
        System.out.println(" === Alarm warn!!!! 水已经烧开了！当前温度"+ event.getHeaterEventSource().getTemperature() + " ");
    }

    @Override
    public void update(WaterBoilEvent event) {
        alertWarn(event);
    }

}
