package com.dynamic.springbootbvexcetionhandler.service;

import com.dynamic.springbootbvexcetionhandler.model.Car;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarTest.class);
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testLicensePlateNotUpperCase() {
        Car car = new Car("Morris", "dd-ab-123", 4);
        LOGGER.info(car.toString());

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);
        StringBuilder errorMessage = new StringBuilder();
        constraintViolations.forEach(constraintViolation->LOGGER.info(errorMessage.append(constraintViolation.getMessage()).append(",").toString()));
        assertEquals(1, constraintViolations.size());
        assertEquals(
                "Case mode must be UPPER",
                constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void carIsValid() {
        Car car = new Car("manufacturer", "DD-AB-123", 2);
        LOGGER.info(car.toString());
        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);
        StringBuilder errorMessage = new StringBuilder();
        constraintViolations.forEach(constraintViolation->LOGGER.info(errorMessage.append(constraintViolation.getConstraintDescriptor().getPayload()).append(",").append(constraintViolation.getMessage()).append(",").toString()));
        assertEquals(0, constraintViolations.size());
    }
    @Test
    public void carIsNotValid() {
        Car car = new Car(null, "DD-AB-123", 2);
        LOGGER.info(car.toString());
        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);
        StringBuilder errorMessage = new StringBuilder();
        constraintViolations.forEach(constraintViolation->LOGGER.info(errorMessage.append(constraintViolation.getConstraintDescriptor().getPayload()).append(",").append(constraintViolation.getMessage()).append(",").toString()));
        assertEquals(1, constraintViolations.size());
    }
}

