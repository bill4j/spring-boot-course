package com.dynamic.springbootfilter.event.jdkbasedevent;

import java.util.EventObject;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class WaterBoilEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public WaterBoilEvent(Object source) {
        super(source);
    }

    public WaterBoilEvent(HeaterEventSource heaterEventSource) {
        super(heaterEventSource);
    }

    public HeaterEventSource getHeaterEventSource() {
        return (HeaterEventSource) super.getSource();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("event.jdkbasedevent.WaterBoilEvent{");
        sb.append("source=").append(source);
        sb.append('}');
        return sb.toString();
    }
}
