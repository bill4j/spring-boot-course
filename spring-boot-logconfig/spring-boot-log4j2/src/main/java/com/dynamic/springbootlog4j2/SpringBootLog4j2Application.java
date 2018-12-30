package com.dynamic.springbootlog4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dynamic")
public class SpringBootLog4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLog4j2Application.class, args);
    }

}

