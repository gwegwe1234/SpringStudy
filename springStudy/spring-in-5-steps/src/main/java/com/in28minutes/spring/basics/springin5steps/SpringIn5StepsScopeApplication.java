package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsScopeApplication {

  private static Logger LOG = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

  public static void main(String[] args) {

    ApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsScopeApplication.class, args);

    PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
    PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);

    LOG.info("{}", personDAO);
    LOG.info("{}", personDAO.getJdbcConnection());
    LOG.info("{}", personDAO2);
    LOG.info("{}", personDAO2.getJdbcConnection());


  }
}
