package com.dynamic.bill4j.springbootcallback.validation;

import javax.validation.Payload;

/**
 * playload for validation error level
 * Created by Administrator on 2019/1/8.
 * commpany: yonyou
 * version:v1.0.,0
 */
public class Severity {
    public interface Info extends Payload {
    }
    public interface warn extends Payload {
    }
    public interface Error extends Payload {
    }
}
