package com.dynamic.springbootfilter.event.delegatebyreflection;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class HeaterEventTest {
    public static void main(String[] args) {
        Integer temperature = 98;
        HeaterNotifier heaterNotifier = new HeaterNotifier();
        heaterNotifier.addListener(new AlarmListener(), "alertWarn", temperature);
        heaterNotifier.addListener(new DIsplayListener(), "showTemperature", temperature);
        try{
            //开水 烧了 一段时间后
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        heaterNotifier.boilWater(temperature);
    }
}
