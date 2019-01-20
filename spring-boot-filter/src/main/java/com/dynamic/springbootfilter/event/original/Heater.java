package com.dynamic.springbootfilter.event.original;

/**
 * Description :
 *
 * @author Administrator
 * @date 2019/1/20
 * company: yonyou
 * version:v1.0.0
 */
public class Heater {
    private int temperature;

    public void display() {
        System.out.printf("当前温度是:%d°, ",temperature);

    }
    public void alertWarn() {
        System.out.println("水已经烧开了！");
    }

    public void boilWater() {
        if (temperature > 96) {
            this.display();
            this.alertWarn();
        }
    }
    public Heater(int temperature) {
        this.temperature = temperature;
    }

    public int  getTemperature() {
        return temperature;
    }

    public void setTemperature(int  temperature) {
        this.temperature = temperature;
    }

    public static void main(String[] args) {
        Heater heater = new Heater(97);
        heater.boilWater();
    }
}
