package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.cdi.SomeCDIBusiness;
import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsCdiApplication {

  private static Logger LOG = LoggerFactory.getLogger(SpringIn5StepsCdiApplication.class);

  public static void main(String[] args) {

    ApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsCdiApplication.class, args);

    SomeCDIBusiness someCDIBusiness = applicationContext.getBean(SomeCDIBusiness.class);

    LOG.info("{}", someCDIBusiness);

  }
}
