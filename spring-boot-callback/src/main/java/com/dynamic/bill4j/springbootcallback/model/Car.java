package com.dynamic.bill4j.springbootcallback.model;

import com.dynamic.bill4j.springbootcallback.validation.Severity;
import com.dynamic.bill4j.springbootcallback.validation.ValidLicensePlate;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * test custom validation annotation @CheckCase
 * Created by Administrator on 2019/1/7.
 * commpany: yonyou
 * version:v1.0.0
 */
@Data
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
}