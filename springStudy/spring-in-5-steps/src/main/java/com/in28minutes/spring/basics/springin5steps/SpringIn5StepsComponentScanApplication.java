package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.componentscan.ComponentDAO;
import com.in28minutes.spring.basics.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.in28minutes.spring.basics.componentscan") // => 타 패키지를 참고하려면 추가 필요
public class SpringIn5StepsComponentScanApplication {

  private static Logger LOG = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

  public static void main(String[] args) {

    ApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsComponentScanApplication.class, args);

    ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
    ComponentDAO componentDAO2 = applicationContext.getBean(ComponentDAO.class);

    LOG.info("{}", componentDAO);
    LOG.info("{}", componentDAO.getComponentJdbcConnection());
    LOG.info("{}", componentDAO2);
    LOG.info("{}", componentDAO2.getComponentJdbcConnection());


  }
}
