package com.dynamic.springbootfilter.event.jdkbasedevent;

import java.util.EventListener;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public interface HeaterLisener extends EventListener {
    void update(WaterBoilEvent event);

}
