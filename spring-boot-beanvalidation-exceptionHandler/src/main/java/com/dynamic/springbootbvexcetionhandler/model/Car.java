package com.dynamic.springbootbvexcetionhandler.model;

import com.dynamic.springbootbvexcetionhandler.service.Severity;
import com.dynamic.springbootbvexcetionhandler.validation.ValidLicensePlate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * test custom validation annotation @CheckCase
 * Created by Administrator on 2019/1/7.
 * commpany: yonyou
 * version:v1.0.0
 */
public class Car {
    @NotNull(message = "manufacturer is not allowed to be empty !",payload = Severity.Error.class)
    private String manufacturer;
/*
    @NotNull
    @Size(min = 2, max = 14)
    @CheckCase(value = CaseMode.UPPER,message = "Case mode must be {value}")
    private String licensePlate;*/

    @ValidLicensePlate(payload = Severity.warn.class,message = "licensePlate should not be null and must lt 2, and rt 14")
    private String licensePlate;


    @Min(value = 2,message = "seatCount not specified, but not mandatory",
            payload = Severity.Info.class)
    private int seatCount;
    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.springbootbvexcetionhandler.model.Car{");
        sb.append("manufacturer='").append(manufacturer).append('\'');
        sb.append(", licensePlate='").append(licensePlate).append('\'');
        sb.append(", seatCount=").append(seatCount);
        sb.append('}');
        return sb.toString();
    }
}