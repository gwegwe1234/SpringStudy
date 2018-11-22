package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.properties.SomeExternalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

  public static void main(String[] args) {

    ApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsPropertiesApplication.class, args);

    SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);

    System.out.println(someExternalService.returnServiceUrl());

  }
}
