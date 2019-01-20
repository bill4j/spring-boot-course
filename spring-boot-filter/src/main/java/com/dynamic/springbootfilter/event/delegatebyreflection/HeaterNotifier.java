package com.dynamic.springbootfilter.event.delegatebyreflection;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class HeaterNotifier extends Notifier {
    private Integer temperature ;
    @Override
    public void addListener(Object object, String methodName, Object... args) {
        System.out.println("有新的 listener 委托尽职尽责的 Notifier 进行放哨!");
        EventHandler handler = this.getEventHandler();
        handler.addEvent(object, methodName, args);
    }

    @Override
    public void notifyAllListeners() {
        System.out.println("尽职尽责的 Notifier 告诉所有需要帮忙通知的 listener 对象 ");
        try{
            this.getEventHandler().notifyX();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void boilWater(Integer warningTemperature ) {
        for (int i = 0; i <= 100; i++) {
            this.temperature = i;
            // 当温度超过设定的阈值，通知Listeners , 跳出循环
            if (warningTemperature < temperature ) {
                notifyAllListeners();
                break;
            }
        }
    }
}
