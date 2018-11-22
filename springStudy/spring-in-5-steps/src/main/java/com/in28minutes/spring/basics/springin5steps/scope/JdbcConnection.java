package com.in28minutes.spring.basics.springin5steps.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) // => 하위 빈이 prototype으로 생성되고 싶으면, proxyMode 추가해줘야한다.
public class JdbcConnection {

  public JdbcConnection() {
    System.out.println("JDBC Connection");
  }
}
