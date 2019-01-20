package com.dynamic.springbootfilter.event.delegatebyreflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : eventHandler
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class EventHandler {

    private List<Event> objects;

    public EventHandler(){
        objects=new ArrayList<Event>();
    }
    /**
     * 添加某个对象要执行的事件，及需要的参数
     */
    public void addEvent(Object object,String methodName,Object...args){
        objects.add(new Event(object,methodName,args));
    }

    /**
     * 通知所有的对象执行指定的事件
      * @throws Exception
     */
    public void notifyX() throws Exception{
        for(Event e : objects){
            e.invoke();
        }
    }
}
