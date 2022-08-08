package com.omas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.omas.controller.RestAPIController;

@SpringBootApplication
// @ComponentScan(basePackageClasses = RestAPIController.class)
@ComponentScan(basePackageClasses = RestServiceApplication.class)
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
