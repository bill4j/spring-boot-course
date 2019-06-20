package com.dynamic.bill4j;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bill
 */
@EnableSwagger2Doc
@SpringBootApplication
public class SpringBootMybatisredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisredisApplication.class, args);
	}

}