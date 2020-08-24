package com.gwegwe.springboot;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleStartedListener implements ApplicationListener<ApplicationStartedEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
    System.out.println("================");
    System.out.println("Application End Point");
    System.out.println("================");
    /*
    2020-08-24 23:23:15.247  INFO 22980 --- [           main] com.gwegwe.springboot.Application        : Started Application in 15.992 seconds (JVM running for 21.343)
    ================
    Application End Point
    ================
     */
  }
}
