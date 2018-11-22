package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.xml.XMLPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIn5StepsXMLContextApplication {

  private static Logger LOG = LoggerFactory.getLogger(SpringIn5StepsXMLContextApplication.class);

  public static void main(String[] args) {

    try(ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml")) { // => java7에서 나온 걍 자동으로 파이널리처럼 닫는거

      LOG.info("Beans Loaded -> {}", (Object)applicationContext.getBeanDefinitionNames());


      XMLPersonDAO xmlPersonDAO = applicationContext.getBean(XMLPersonDAO.class);
      System.out.println(xmlPersonDAO);
      System.out.println(xmlPersonDAO.getXmlJdbcConnection());

    }
  }
}
