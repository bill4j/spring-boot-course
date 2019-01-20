package com.dynamic.springbootfilter.event.delegatebyreflection;

/**
 * Description : 
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class AlarmListener  {

    public void alertWarn(Integer data) {
        System.out.println(" === Alarm warn!!!! 水已经烧开了！当前温度"+ data + " ");
    }


}
