package com.dynamic.springbootfilter.event.delegatebyreflection;
/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public abstract class Notifier {

    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * 增加需要帮忙 放哨 的 Listener
     *
     * @param object 要执行方法的对象
     * @param methodName 执行方法 的方法名
     * @param args   执行方法的参数
     */
    public abstract void addListener(Object object, String methodName,
                                     Object... args);

    /**
     * 告诉所有要帮忙放哨的 Listener：
     */
    public abstract void notifyAllListeners();

}
