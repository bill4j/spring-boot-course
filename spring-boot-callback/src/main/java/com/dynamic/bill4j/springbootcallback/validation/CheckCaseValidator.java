package com.dynamic.bill4j.springbootcallback.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * CheckCaseValidator  test demo
 *
 * @author Administrator
 * @date 2019/1/7
 * commpany: yonyou
 * version:v1.0.0
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;
    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }
    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

        if (object == null) {
            return true;
        }
        boolean isValid;
        if (caseMode == CaseMode.UPPER) {
            isValid = object.equals(object.toUpperCase());
        } else {
            isValid= object.equals(object.toLowerCase());
        }


        if(!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("Case mode must be {value}")
                    .addPropertyNode("value").addConstraintViolation();
        }
        return isValid;
    }
}
